package com.infp.ciat.board.controller.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/***
 * 게시판(피드)생성 요청 dto
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CreateBoardRequestForm {
    @NotEmpty
    private String content;
    private MultipartHttpServletRequest multipartHttpServletRequest;

    @Builder
    public CreateBoardRequestForm(String content, MultipartHttpServletRequest multipartHttpServletRequest) {
        this.content = content;
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }
}
