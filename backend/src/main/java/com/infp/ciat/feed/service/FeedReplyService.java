package com.infp.ciat.feed.service;

import com.infp.ciat.feed.repository.FeedReplyRepository;
import com.infp.ciat.feed.entity.FeedReply;
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
