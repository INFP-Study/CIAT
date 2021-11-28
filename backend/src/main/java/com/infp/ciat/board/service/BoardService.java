package com.infp.ciat.board.service;

import com.infp.ciat.common.exceptions.FailCreateBoard;
import com.infp.ciat.config.auth.PrincipalDetails;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

    Long create(String content, MultipartHttpServletRequest multipartHttpServletRequest, PrincipalDetails user) throws FailCreateBoard;
}
