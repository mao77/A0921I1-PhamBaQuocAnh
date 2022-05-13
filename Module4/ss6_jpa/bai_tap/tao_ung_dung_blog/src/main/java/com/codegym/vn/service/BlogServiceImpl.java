package com.codegym.vn.service;

import com.codegym.vn.entity.Blog;
import com.codegym.vn.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(b -> blogs.add(b));
        return blogs;
    }

    @Override
    public void create(Blog blog) {
         blogRepository.save(blog);
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(long id) {
        blogRepository.deleteById(id);
    }
}
