package com.infp.ciat.feed.controller.dto;

import lombok.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/***
 * 게시판(피드)생성 요청 dto
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CreateFeedRequestForm {
    private String title;
    private String content;
    private MultipartHttpServletRequest multipartHttpServletRequest;

    @Builder
    public CreateFeedRequestForm(String title, String content, MultipartHttpServletRequest multipartHttpServletRequest) {
        this.title = title;
        this.content = content;
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }
}
