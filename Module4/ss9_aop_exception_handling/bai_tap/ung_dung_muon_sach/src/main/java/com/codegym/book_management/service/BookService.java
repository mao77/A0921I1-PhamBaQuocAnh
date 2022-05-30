package com.codegym.book_management.service;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BookService {
    List<Book> findAll();
    Book findById(int id);

    void save(Book book);

    List<Book> findAllBookByLibraryId(int id);

    List<Book> findAvailableBookByLibraryId(int id);

    List<Book> findUsedBookByLibraryId(int id);

    void returnBookByCode(Library library, int returnCode);
}
