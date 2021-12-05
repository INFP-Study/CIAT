package com.infp.ciat.feed.repository;

import com.infp.ciat.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM menu WHERE show_yn = 'Y'")
    List<Feed> findAllNotDeleted();

    @Query(nativeQuery = true, value = "SELECT * FROM menu WHERE id = :id AND show_yn = 'Y'")
    Optional<Feed> findByIdNotDeleted(@Param("id") Long id);

}
