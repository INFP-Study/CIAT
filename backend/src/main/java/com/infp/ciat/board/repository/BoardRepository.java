package com.infp.ciat.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infp.ciat.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM board WHERE show_yn = 'Y'")
    List<Board> findAllNotDeleted();

    @Query(nativeQuery = true, value = "SELECT * FROM board WHERE id = :id AND show_yn = 'Y'")
    Optional<Board> findByIdNotDeleted(@Param("id") Long id);
}
