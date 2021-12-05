package com.infp.ciat.board.service;

import com.infp.ciat.board.entity.FeedReply;
import com.infp.ciat.board.repository.FeedReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedReplyService {

    private final FeedReplyRepository feedReplyRepository;

    @Transactional
    public Long save(FeedReply reply) {
        return feedReplyRepository.save(reply).getId();
    }
}
