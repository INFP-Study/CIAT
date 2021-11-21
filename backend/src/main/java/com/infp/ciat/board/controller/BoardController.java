package com.infp.ciat.board.controller;

import com.infp.ciat.board.dto.CreateBoardRequestForm;
import com.infp.ciat.board.service.UploadImagesService;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final UploadImagesService uploadImagesService;

    @PostMapping("/create")
    public String create(@RequestParam(value = "title") String title,
                         @RequestParam(value = "content") String content,
                         MultipartHttpServletRequest multipartHttpServletRequest,
                         @AuthenticationPrincipal PrincipalDetails user) {
        log.info("--- create board API is called ----");
        Account account = user.getAccount();
        CreateBoardRequestForm requestForm = CreateBoardRequestForm.builder()
                .title(title)
                .content(content)
                .multipartHttpServletRequest(multipartHttpServletRequest)
                .build();

        log.info(String.format("[Create board] login user info -> email:%s, id:%s", account.getEmail(), account.getId()));
        log.info(String.format("[Create board] request_body: %s", requestForm.toString()));
        // todo 게시판 게시판생성

        uploadImagesService.Upload(requestForm);

        return "success";
    }
}