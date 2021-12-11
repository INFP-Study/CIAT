package com.infp.ciat.feed.service;

import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.feed.controller.dto.CreateFeedRequestForm;
import com.infp.ciat.feed.controller.dto.FeedDto;
import com.infp.ciat.feed.controller.dto.FeedSaveRequestDto;
import com.infp.ciat.feed.repository.FeedRepository;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
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
        // todo 게시판 게시판생성
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

    @Override
    public List<FeedDto> getList() {
        return feedRepository.findAllNotDeleted().stream()
                .map(f -> new FeedDto(f))
                .collect(Collectors.toList());
    }
}