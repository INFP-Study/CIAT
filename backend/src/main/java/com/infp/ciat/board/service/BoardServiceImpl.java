package com.infp.ciat.board.service;

import com.infp.ciat.board.controller.dto.BoardSaveRequestDto;
import com.infp.ciat.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public Long create(BoardSaveRequestDto requestDto) {

        return boardRepository.save(requestDto.toEntity()).getId();
    }
}
