package com.infp.ciat.feed.controller.dto;

import com.infp.ciat.feed.entity.Feed;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedSaveRequestDto {

    private String content;
    private List<String> pictureList;
    private Account account;

    @Builder
    public FeedSaveRequestDto(String content, List<String> pictureList, Account account) {
        this.content = content;
        this.pictureList = pictureList;
        this.account = account;
    }

    public Feed toEntity() {
        return Feed.builder()
                .content(content)
                .pictureList(pictureList)
                .account(account)
                .build();
    }
}
