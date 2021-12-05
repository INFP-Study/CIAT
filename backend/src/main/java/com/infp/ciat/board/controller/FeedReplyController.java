package com.infp.ciat.board.controller;

import com.infp.ciat.board.entity.FeedReply;
import com.infp.ciat.board.service.FeedReplyService;
import com.infp.ciat.config.auth.PrincipalDetails;
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
        log.debug(feedReply.toString());
        feedReply.setAccount(user.getAccount());
      return feedReplyService.save(feedReply);
    }
}
