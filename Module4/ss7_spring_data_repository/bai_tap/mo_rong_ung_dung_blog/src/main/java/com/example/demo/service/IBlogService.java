package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void save();

    void edit();

    Page<Blog> getAllBlog(String author, String category, Pageable pageable );

    Page<Blog> findBlogsByAuthorContaining(String name,Pageable pageable);

    Page<Blog> findBlogsByAuthorContainingAndCategory_Name(String author,String category,Pageable pageable);
}
