package com.infp.ciat.board.repository;

import com.infp.ciat.board.entity.FeedReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedReplyRepository extends JpaRepository<FeedReply, Long> {
}
