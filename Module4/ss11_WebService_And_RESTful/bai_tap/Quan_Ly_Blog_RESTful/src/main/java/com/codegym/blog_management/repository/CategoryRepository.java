package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "select * from Category ", nativeQuery = true)
    List<Category> findAll();
}
