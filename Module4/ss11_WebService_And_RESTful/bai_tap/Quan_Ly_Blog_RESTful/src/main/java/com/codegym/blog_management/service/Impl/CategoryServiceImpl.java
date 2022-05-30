package com.codegym.blog_management.service.Impl;


import com.codegym.blog_management.entity.Category;
import com.codegym.blog_management.repository.CategoryRepository;
import com.codegym.blog_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(c -> categories.add(c));
        return categories;
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null){
            categoryRepository.delete(category);
        }
    }
}
