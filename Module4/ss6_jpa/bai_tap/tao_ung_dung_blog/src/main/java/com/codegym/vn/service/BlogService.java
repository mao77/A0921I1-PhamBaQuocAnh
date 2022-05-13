package com.codegym.vn.service;

import com.codegym.vn.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void create(Blog blog);
    Blog findById(long id);
    void edit(Blog blog);
    void delete(long id);
}
