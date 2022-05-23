package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save() {

    }

    @Override
    public void edit() {

    }

    @Override
    public Page<Blog> getAllBlog(String author, String category, Pageable pageable) {
        return blogRepository.findAll(author, category, pageable);
    }

    @Override
    public Page<Blog> findBlogsByAuthorContaining(String name, Pageable pageable) {
        return blogRepository.findBlogsByAuthorContaining(name,pageable);
    }

    @Override
    public Page<Blog> findBlogsByAuthorContainingAndCategory_Name(String author, String category, Pageable pageable) {
        return blogRepository.findBlogsByAuthorContainingAndCategory_Name(author,category,pageable);
    }


//    @Override
//    public Page<Blog> getAllBlog(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }
}
