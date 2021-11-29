package com.infp.ciat.board.controller.dto;

import com.infp.ciat.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardDto {

    private Long boardId;
    private String content;
    private List<String> pictureList;
    private Long accountId;
    private String nickname;
//    private List<BoardReply> replyList;
    private LocalDateTime createdDate;

    public BoardDto(Board board) {
        boardId = board.getId();
        content = board.getContent();
        pictureList = board.getPictureList();
        accountId = board.getAccount().getId();
        nickname = board.getAccount().getNickname();
        createdDate = board.getCreatedDate();
    }
}
