package com.infp.ciat.feed.controller;

import com.infp.ciat.feed.controller.dto.FeedDetailDto;
import com.infp.ciat.feed.controller.dto.FeedDto;
import com.infp.ciat.feed.controller.dto.FeedUpdateRequestDto;
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
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/feed/{feedId}")
    public ResponseEntity<FeedDetailDto> getOneFeed(@PathVariable Long feedId) {
        return new ResponseEntity<>(feedService.getOneFeed(feedId), HttpStatus.OK);
    }

    @PutMapping("/feed/{feedId}")
    public ResponseEntity<FeedDto> updateFeed(
            @PathVariable Long feedId,
            @RequestBody FeedUpdateRequestDto requestDto,
            @AuthenticationPrincipal PrincipalDetails user)
    {
        loginCheck(user);
        return new ResponseEntity<>(feedService.updateFeed(feedId, requestDto, user.getAccount().getId()), HttpStatus.OK);
    }

    @PatchMapping("/feed/{feedId}")
    public ResponseEntity<?> deleteFeed(@PathVariable Long feedId, @AuthenticationPrincipal PrincipalDetails user) {
        loginCheck(user);

        feedService.deleteFeed(feedId, user.getAccount().getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public void loginCheck(PrincipalDetails user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");
        }
    }
}
