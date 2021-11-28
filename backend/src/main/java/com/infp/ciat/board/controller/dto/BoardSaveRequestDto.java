package com.infp.ciat.board.controller.dto;

import com.infp.ciat.board.entity.Board;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BoardSaveRequestDto {

    private String content;
    private List<String> pictureList;
    private Account account;

    @Builder
    public BoardSaveRequestDto(String content, List<String> pictureList, Account account) {
        this.content = content;
        this.pictureList = pictureList;
        this.account = account;
    }

    public Board toEntity() {
        return Board.builder()
                .content(content)
                .pictureList(pictureList)
                .account(account)
                .build();
    }
}
