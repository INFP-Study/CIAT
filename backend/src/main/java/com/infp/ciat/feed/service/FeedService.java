package com.infp.ciat.feed.service;

import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.feed.controller.dto.FeedDetailDto;
import com.infp.ciat.feed.controller.dto.FeedDto;
import com.infp.ciat.feed.controller.dto.FeedUpdateRequestDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface FeedService {

    Long create(String content, MultipartHttpServletRequest multipartHttpServletRequest, PrincipalDetails user) throws FailCreateFeed;

    List<FeedDto> getList(Long lastFeedId, int size);

    FeedDetailDto getOneFeed(Long feedId);

    FeedDto updateFeed(Long feedId, FeedUpdateRequestDto requestDto, Long userId);

    void deleteFeed(Long feedId, Long userId);
}
