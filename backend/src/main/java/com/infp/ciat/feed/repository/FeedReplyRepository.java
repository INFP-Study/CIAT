package com.infp.ciat.feed.repository;

import com.infp.ciat.feed.entity.FeedReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedReplyRepository extends JpaRepository<FeedReply, Long> {
}