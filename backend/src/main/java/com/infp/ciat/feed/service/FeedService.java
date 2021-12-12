package com.infp.ciat.feed.service;

import com.infp.ciat.common.exceptions.FailCreateFeed;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.feed.controller.dto.FeedDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface FeedService {

    Long create(String content, MultipartHttpServletRequest multipartHttpServletRequest, PrincipalDetails user) throws FailCreateFeed;

    List<FeedDto> getList(Long lastFeedId, int size);
}
