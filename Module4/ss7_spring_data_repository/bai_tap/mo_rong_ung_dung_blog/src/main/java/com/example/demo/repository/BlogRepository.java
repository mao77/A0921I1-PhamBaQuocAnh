package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ) abc ")
    Page<Blog> findAll(@Param("author") String author,@Param("category") String category, Pageable pageable);
    Page<Blog> findBlogsByAuthorContaining(String name,Pageable pageable);
    Page<Blog> findBlogsByAuthorContainingAndCategory_Name(String author,String category,Pageable pageable);
}
