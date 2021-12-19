package com.infp.ciat.feed.controller.dto;

import com.infp.ciat.feed.entity.FeedReply;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class FeedReplyDto {

    private final Long id;
    private final String author;
    private final String comment;
    private final LocalDateTime regDate;

    public FeedReplyDto(FeedReply reply) {
        this.id = reply.getId();
        this.author = reply.getAccount().getNickname();
        this.comment = reply.getContent();
        this.regDate = reply.getCreatedDate();
    }
}
