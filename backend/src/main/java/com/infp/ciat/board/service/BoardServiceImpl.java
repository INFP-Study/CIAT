package com.infp.ciat.board.service;

import com.infp.ciat.board.controller.dto.BoardDto;
import com.infp.ciat.board.controller.dto.BoardSaveRequestDto;
import com.infp.ciat.board.controller.dto.CreateBoardRequestForm;
import com.infp.ciat.board.repository.BoardRepository;
import com.infp.ciat.common.exceptions.FailCreateBoard;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UploadImagesService uploadImagesService;

    @Transactional
    @Override
    public Long create(String content, MultipartHttpServletRequest multipartHttpServletRequest, PrincipalDetails user) throws FailCreateBoard {

        log.info("--- create board API is called ----");
        Account account = user.getAccount();
        CreateBoardRequestForm requestForm = CreateBoardRequestForm.builder().content(content)
                .multipartHttpServletRequest(multipartHttpServletRequest).build();

        log.info(String.format("[Create board] login user info -> email:%s, id:%s", account.getEmail(), account.getId()));
        log.info(String.format("[Create board] request_body: %s", requestForm.toString()));
        // todo 게시판 게시판생성
        List<String> pictureList = uploadImagesService.Upload(requestForm);
        String textContent = requestForm.getContent();

        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .content(textContent)
                .pictureList(pictureList)
                .account(account)
                .build();
        // debug log
        log.info(pictureList.toString());

        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public List<BoardDto> getList() {
        return boardRepository.findAllNotDeleted().stream()
                .map(b -> new BoardDto(b))
                .collect(Collectors.toList());
    }
}
