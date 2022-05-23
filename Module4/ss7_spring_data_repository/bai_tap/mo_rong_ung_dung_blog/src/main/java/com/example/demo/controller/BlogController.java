package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categoryList")
    public List<Category> setCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @GetMapping("")
    public String getAllBlog(
            @RequestParam(defaultValue = "") String key_author,
            @RequestParam(defaultValue = "") String key_category
            ,@PageableDefault(size = 2) Pageable pageable
            , Model model) {
        Page<Blog> blogs = iBlogService.getAllBlog(key_author, key_category, pageable);
        model.addAttribute("blogs", blogs);
        return "list" ;
    }

    @PostMapping("/search")
    public String getSearchBlogs(
            @RequestParam String key_author,
            @RequestParam String key_category,
            @PageableDefault(size = 2) Pageable pageable,
            Model model
    ){
        Page<Blog> blogs = iBlogService.findBlogsByAuthorContainingAndCategory_Name(key_author,key_category,pageable);
        model.addAttribute("blogs",blogs);
        return "list";
    }


}
