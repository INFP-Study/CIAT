package com.infp.ciat.category.repository;

import com.infp.ciat.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM category WHERE menu_id = :menu_id AND show_yn = 'Y'")
    List<Category> findAllNotDeleted(@Param("menu_id") Long menuId);

    @Query(nativeQuery = true, value = "SELECT * FROM category WHERE menu_id = :menu_id AND account_id = :account_id AND show_yn = 'Y'")
    List<Category> findAllNotDeletedOnlyForPlantMenu(@Param("menu_id") Long menuId, @Param("account_id") Long account_id);

    @Query(nativeQuery = true, value = "SELECT * FROM category WHERE id = :id AND show_yn = 'Y'")
    Optional<Category> findByIdNotDeleted(@Param("id") Long id);
}
