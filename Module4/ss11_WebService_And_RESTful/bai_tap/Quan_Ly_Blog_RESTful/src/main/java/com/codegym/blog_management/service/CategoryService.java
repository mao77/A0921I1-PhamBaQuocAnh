package com.codegym.blog_management.service;


import com.codegym.blog_management.entity.Category;

import java.util.List;

public interface CategoryService {
    public void create(Category category);
    List<Category> findAll();
    public void update(Category category);
    Category findById(Long id);
    public void delete(Long id);
}
