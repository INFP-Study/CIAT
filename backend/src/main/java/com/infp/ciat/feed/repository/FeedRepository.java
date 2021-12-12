package com.infp.ciat.feed.repository;

import com.infp.ciat.feed.entity.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM feed WHERE show_yn = 'Y'")
    List<Feed> findAllNotDeleted();

    @Query(nativeQuery = true, value = "SELECT * FROM feed WHERE id = :id AND show_yn = 'Y'")
    Optional<Feed> findByIdNotDeleted(@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM feed WHERE id < :last_feed_id AND show_yn = 'Y'")
    Page<Feed> findAllNotDeletedWithPaging(@Param("last_feed_id") Long lastFeedId, Pageable pageable);
}
