package com.infp.ciat.board.controller;

import com.infp.ciat.board.controller.dto.BoardSaveRequestDto;
import com.infp.ciat.board.controller.dto.CreateBoardRequestForm;
import com.infp.ciat.board.service.BoardService;
import com.infp.ciat.board.service.UploadImagesService;
import com.infp.ciat.common.exceptions.FailCreateBoard;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

  private final UploadImagesService uploadImagesService;
  private final BoardService boardService;

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestParam(value = "content") String content,
      MultipartHttpServletRequest multipartHttpServletRequest, @AuthenticationPrincipal PrincipalDetails user)
      throws FailCreateBoard {

    return new ResponseEntity<>(boardService.create(content, multipartHttpServletRequest, user), HttpStatus.CREATED);
  }
}
