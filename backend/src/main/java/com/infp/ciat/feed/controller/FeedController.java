package com.infp.ciat.feed.controller;

import com.infp.ciat.feed.controller.dto.FeedDto;
import com.infp.ciat.feed.service.FeedService;
import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/feed")
    public ResponseEntity<?> create(@RequestParam(value = "content") String content,
                                    MultipartHttpServletRequest multipartHttpServletRequest,
                                    @AuthenticationPrincipal PrincipalDetails user)
            throws FailCreateFeed {

        return new ResponseEntity<>(feedService.create(content, multipartHttpServletRequest, user), HttpStatus.CREATED);
    }

    @GetMapping("/feeds")
    public ResponseEntity<List<FeedDto>> getList(@RequestParam Long lastFeedId, @RequestParam int size) {
        return new ResponseEntity<>(feedService.getList(lastFeedId, size), HttpStatus.OK);
    }
}
