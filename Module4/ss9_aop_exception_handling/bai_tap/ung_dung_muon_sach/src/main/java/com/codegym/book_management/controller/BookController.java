package com.codegym.book_management.controller;
import com.codegym.book_management.service.BookService;
import com.codegym.book_management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    LibraryService libraryService;

}
