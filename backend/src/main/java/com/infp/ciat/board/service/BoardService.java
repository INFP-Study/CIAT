package com.infp.ciat.board.service;

import com.infp.ciat.board.controller.dto.BoardSaveRequestDto;

public interface BoardService {

    Long create(BoardSaveRequestDto requestDto);
}
