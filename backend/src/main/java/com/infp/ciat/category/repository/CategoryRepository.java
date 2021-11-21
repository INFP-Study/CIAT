package com.infp.ciat.category.repository;

import com.infp.ciat.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM category WHERE show_yn = 'Y'")
    List<Category> findAllNotDeleted();

    @Query(nativeQuery = true, value = "SELECT * FROM category WHERE id = :id AND show_yn = 'Y'")
    Optional<Category> findByIdNotDeleted(Long id);
}
