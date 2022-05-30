package com.codegym.book_management.service;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import com.codegym.exception.NotAvailableException;
import com.codegym.exception.WrongCodeException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface LibraryService {
    public List<Library> findAll();
    void save(Library library);
    Library findById(int id);
    void borrow(Library library, int usedCode);
    void delete(int id);
    Book getNextAvailableCode(Library library) throws NotAvailableException;
    void returnBook(Library library, int returnCode) throws NotAvailableException, WrongCodeException;
    public boolean checkNoUsedCode(Library library);
}
