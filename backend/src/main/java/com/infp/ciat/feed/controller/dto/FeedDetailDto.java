package com.infp.ciat.feed.controller.dto;

import com.infp.ciat.feed.entity.Feed;
import com.infp.ciat.feed.entity.FeedLike;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class FeedDetailDto {

    private final Long id;
    private final String author;
    private final String content;
    private final LocalDateTime date;
    private final List<String> src;
    private final List<FeedLike> like;
    private final List<FeedReplyDto> comments;

    public FeedDetailDto(Feed feed){
        this.id = feed.getId();
        this.author = feed.getAccount().getNickname();
        this.content = feed.getContent();
        this.date = feed.getCreatedDate();
        this.src = feed.getPictureList();
        this.like = new ArrayList<>();
        this.comments = feed.getReplies().stream()
                .map(FeedReplyDto::new)
                .collect(Collectors.toList());
    }
}
