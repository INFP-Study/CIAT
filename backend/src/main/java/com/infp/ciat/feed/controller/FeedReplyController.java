package com.infp.ciat.feed.controller;

import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.feed.entity.FeedReply;
import com.infp.ciat.feed.service.FeedReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reply")
@RequiredArgsConstructor
@Slf4j
public class FeedReplyController {

    private final FeedReplyService feedReplyService;

    @PostMapping("/save")
    public Long save(@RequestBody FeedReply feedReply, @AuthenticationPrincipal PrincipalDetails user) {
        feedReply.setAccount(user.getAccount());
        return feedReplyService.save(feedReply);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody FeedReply feedReply, @AuthenticationPrincipal PrincipalDetails user) {
        feedReplyService.delete(feedReply);
    }

}