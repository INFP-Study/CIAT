package com.infp.ciat.feed.service;

import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.feed.controller.dto.*;
import com.infp.ciat.feed.entity.Feed;
import com.infp.ciat.feed.repository.FeedRepository;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import com.infp.ciat.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
    private final AccountRepository accountRepository;
    private final UploadImagesService uploadImagesService;

    @Transactional
    @Override
    public Long create (String content,
                        MultipartHttpServletRequest multipartHttpServletRequest,
                        PrincipalDetails user)
            throws FailCreateFeed {

        log.info("--- create board API is called ----");
        Account account = user.getAccount();
        CreateFeedRequestForm requestForm = CreateFeedRequestForm.builder()
                .content(content)
                .multipartHttpServletRequest(multipartHttpServletRequest)
                .build();

        log.info(String.format("[Create board] login user info -> email:%s, id:%s", account.getEmail(), account.getId()));
        log.info(String.format("[Create board] request_body: %s", requestForm.toString()));
        // todo ????????? ???????????????
        List<String> pictureList = uploadImagesService.upload(requestForm);
        String textContent = requestForm.getContent();

        FeedSaveRequestDto requestDto = FeedSaveRequestDto.builder()
                .content(textContent)
                .pictureList(pictureList)
                .account(account)
                .build();
        // debug log
        log.info(pictureList.toString());

        return feedRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<FeedDto> getList(Long lastFeedId, int size) {
        return fetchPages(lastFeedId, size).getContent()
                .stream()
                .map(f -> new FeedDto(f))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public FeedDetailDto getOneFeed(Long feedId) {
        return Optional.of(findById(feedId))
                .map(FeedDetailDto::new)
                .get();
    }

    @Transactional
    @Override
    public FeedDto updateFeed(Long feedId, FeedUpdateRequestDto requestDto, Long userId) {

        Feed feed = findById(feedId);

        if (feed.isSameContent(requestDto.getContent())) {
            return toFeedDto(feed);
        }

        if (!isAuthor(feed, userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "?????? ???????????? ???????????? ????????????, ???????????? ???????????????.");
        }

        return toFeedDto(feed.update(requestDto.getContent()));
    }

    @Transactional
    @Override
    public void deleteFeed(Long feedId, Long userId) {
        Feed feed = findById(feedId);

        if (!(isAdmin(userId) || isAuthor(feed, userId))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "?????? ????????? ????????????.");
        }
        feed.delete();
    }

    private Page<Feed> fetchPages(Long lastFeedId, int size) {
        Pageable pageable = PageRequest.of(0, size, Sort.by("id").descending());

        return feedRepository.findAllNotDeletedWithPaging(lastFeedId, pageable);
    }

    private Feed findById(Long feedId) {
        return feedRepository.findByIdNotDeleted(feedId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "???????????? ?????? ??????????????????."));
    }

    private boolean isAuthor(Feed feed, Long userId) {
        return feed.getAccount().getId() == userId;
    }

    private boolean isAdmin(Long userId) {
        return accountRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "???????????????, ???????????? ?????? ???????????????."))
                .getRole().equals(Role.ROLE_ADMIN);
    }

    public FeedDto toFeedDto(Feed feed) {
        return Optional.of(feed)
                .map(FeedDto::new)
                .get();
    }
}
