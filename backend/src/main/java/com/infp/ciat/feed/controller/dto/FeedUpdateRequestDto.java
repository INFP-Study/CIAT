package com.infp.ciat.feed.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FeedUpdateRequestDto {

    private String content;

    public FeedUpdateRequestDto(String content) {
        this.content = content;
    }
}
