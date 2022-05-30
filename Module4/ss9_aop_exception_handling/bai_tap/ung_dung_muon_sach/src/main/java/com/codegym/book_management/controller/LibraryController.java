package com.codegym.book_management.controller;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import com.codegym.book_management.service.BookService;
import com.codegym.book_management.service.LibraryService;
import com.codegym.exception.NotAvailableException;
import com.codegym.exception.NotBorrowException;
import com.codegym.exception.WrongCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("libraries",libraryService.findAll());
        return "/library/list";
    }

    @GetMapping("/library/create")
    public String showCreate(Model model){
        model.addAttribute("library", new Library());
        return "/library/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Library library, Model model){
        libraryService.save(library);
        return "redirect:/list";
    }


    @GetMapping("/library/borrow")
    public String borrow(Model model, @RequestParam int id) throws NotAvailableException {
        Library library = libraryService.findById(id);
        model.addAttribute("library", library);
        model.addAttribute("availableCode", libraryService.getNextAvailableCode(library));
        return "library/borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Library library, @RequestParam int usedCode) {
        libraryService.borrow(library, usedCode);
        return "redirect:/list";
    }

    @GetMapping("/library/{id}/delete")
    public String delete(@PathVariable int id){
        libraryService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/return")
    public String returnPage(Model model, @RequestParam int id) throws NotBorrowException {
        Library library = libraryService.findById(id);
        model.addAttribute("library",library);
       return "library/return";
    }

    @PostMapping("/return")
    public String returnBook(@ModelAttribute Library library, @RequestParam("returnCode") int returnCode) throws NotAvailableException, WrongCodeException {
        libraryService.returnBook(library, returnCode);
        return "redirect:list";
    }

}
