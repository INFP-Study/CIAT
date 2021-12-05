package com.infp.ciat.board.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/***
 * 게시판(피드)생성 요청 dto
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CreateBoardRequestForm {
    private String title;
    private String content;
    private MultipartHttpServletRequest multipartHttpServletRequest;

    @Builder
    public CreateBoardRequestForm(String title, String content, MultipartHttpServletRequest multipartHttpServletRequest) {
        this.title = title;
        this.content = content;
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }
}
