package com.codegym.book_management.service.Impl;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import com.codegym.book_management.repository.BookRepository;
import com.codegym.book_management.repository.LibraryRepository;
import com.codegym.book_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBookByLibraryId(int id) {
        return bookRepository.findBookByLibraryId(id);
    }

    @Override
    public List<Book> findAvailableBookByLibraryId(int id) {
        return bookRepository.findBookByLibrary_IdAndStatus(id,true);
    }

    @Override
    public List<Book> findUsedBookByLibraryId(int id) {
        return bookRepository.findBookByLibrary_IdAndStatus(id, false);
    }

    @Override
    public void returnBookByCode(Library library, int returnCode) {
        Book book = bookRepository.findById(returnCode).orElse(null);
        library = book.getLibrary();
        library.returnBook();
        libraryRepository.save(library);
        book.setStatus(true);
    }


}
