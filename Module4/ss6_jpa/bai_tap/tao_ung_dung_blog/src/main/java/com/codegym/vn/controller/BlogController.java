package com.codegym.vn.controller;

import com.codegym.vn.entity.Blog;
import com.codegym.vn.entity.Category;
import com.codegym.vn.service.BlogService;
import com.codegym.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

//    @GetMapping("")
//    public String showListBlog(Model model){
//        model.addAttribute("categories",categoryService.findAll());
//        return "/blog/list";
//    }

    @GetMapping("")
    public String listAll(Model model) {
        model.addAttribute("blogs",blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog",blog);
        model.addAttribute("categories",categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String view(@RequestParam ("id") long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("edit")
    public String viewEdit(@RequestParam ("id") long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categories",categoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute ("blog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/blog/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") long id) {
        blogService.delete(id);
        return "redirect:/blog/";
    }
}
