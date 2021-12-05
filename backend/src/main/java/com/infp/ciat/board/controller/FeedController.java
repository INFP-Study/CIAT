package com.infp.ciat.feed.controller;

import com.infp.ciat.feed.dto.CreateFeedRequestForm;
import com.infp.ciat.feed.service.UploadImagesService;
import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class FeedController {
    private final UploadImagesService uploadImagesService;

    @PostMapping("/create")
    public String create(@RequestParam(value = "title") String title,
                         @RequestParam(value = "content") String content,
                         MultipartHttpServletRequest multipartHttpServletRequest,
                         @AuthenticationPrincipal PrincipalDetails user) throws FailCreateFeed {
        log.info("--- create feed API is called ----");
        Account account = user.getAccount();
        CreateFeedRequestForm requestForm = CreateFeedRequestForm.builder()
                .title(title)
                .content(content)
                .multipartHttpServletRequest(multipartHttpServletRequest)
                .build();

        log.info(String.format("[Create feed] login user info -> email:%s, id:%s", account.getEmail(), account.getId()));
        log.info(String.format("[Create feed] request_body: %s", requestForm.toString()));
        // todo 게시판 게시판생성

        List<String> images = uploadImagesService.Upload(requestForm);
        // debug log
        log.info(images.toString());

        return "success";
    }
}
