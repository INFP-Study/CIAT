package com.infp.ciat.category.repository;

import com.infp.ciat.category.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM menu WHERE show_yn = 'Y'")
    List<Menu> findAllNotDeleted();

    @Query(nativeQuery = true, value = "SELECT * FROM menu WHERE id = :id AND show_yn = 'Y'")
    Optional<Menu> findByIdNotDeleted(@Param("id") Long id);
}
