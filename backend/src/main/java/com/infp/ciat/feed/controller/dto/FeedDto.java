package com.infp.ciat.feed.controller.dto;

import com.infp.ciat.feed.entity.Feed;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FeedDto {

    private Long feedId;
    private String content;
    private List<String> pictureList;
    private Long accountId;
    private String nickname;
    //    private List<BoardReply> replyList;
    private LocalDateTime createdDate;

    public FeedDto(Feed feed) {
        feedId = feed.getId();
        content = feed.getContent();
        pictureList = feed.getPictureList();
        accountId = feed.getAccount().getId();
        nickname = feed.getAccount().getNickname();
        createdDate = feed.getCreatedDate();
    }
}
