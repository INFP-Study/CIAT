package com.infp.ciat.board.service;

import com.infp.ciat.board.controller.dto.BoardDto;
import com.infp.ciat.common.exceptions.FailCreateBoard;
import com.infp.ciat.config.auth.PrincipalDetails;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {

    Long create(String content, MultipartHttpServletRequest multipartHttpServletRequest, PrincipalDetails user) throws FailCreateBoard;

    List<BoardDto> getList();
}
