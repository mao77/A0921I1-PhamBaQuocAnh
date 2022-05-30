package com.codegym.blog_management.controller;


import com.codegym.blog_management.entity.Category;
import com.codegym.blog_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category){
        categoryService.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "/category/edit";
    }

    @PostMapping("/update")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        categoryService.delete(id);
        return "redirect:/category/list";
    }


}
