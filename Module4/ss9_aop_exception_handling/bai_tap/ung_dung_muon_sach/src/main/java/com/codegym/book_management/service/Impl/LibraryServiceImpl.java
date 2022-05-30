package com.codegym.book_management.service.Impl;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import com.codegym.book_management.repository.BookRepository;
import com.codegym.book_management.repository.LibraryRepository;
import com.codegym.book_management.service.BookService;
import com.codegym.book_management.service.LibraryService;
import com.codegym.exception.NotAvailableException;
import com.codegym.exception.WrongCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
        for(int i = 0; i < library.getQuantity(); i++){
            int n = 10000 + new Random().nextInt(90000);
            Book book = new Book(String.valueOf(n),true,libraryRepository.findById(library.getId()).orElse(null));
            library.generateBook(book);
            bookService.save(book);
        }
    }

    @Override
    public Library findById(int id) {
        return libraryRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Library library, int usedBook) {
        List<Book> bookList = bookService.findAllBookByLibraryId(library.getId());
        for (Book book : bookList){
            if (book.getCode().equals(String.valueOf(usedBook))){
                book.setStatus(false);
                break;
            }
        }
        library.borrow();
        libraryRepository.save(library);
    }

    @Override
    public void delete(int id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public Book getNextAvailableCode(Library library) throws NotAvailableException {
        List<Book> bookList = bookService.findAvailableBookByLibraryId(library.getId());
        if (bookList.size() == 0){
            throw  new NotAvailableException();
        }
        return bookList.get(0);
    }

    @Override
    public void returnBook(Library library, int returnCode) throws NotAvailableException, WrongCodeException {
        List<Book> bookList = bookService.findUsedBookByLibraryId(library.getId());
        if (bookList.size() == 0){
            throw new NotAvailableException();
        }

        boolean isCorrectCode = false;
        for (Book book : bookList){
            if (book.getCode().equals(String.valueOf(returnCode))){
                book.setStatus(true);
                bookService.save(book);
                library.returnBook();
                libraryRepository.save(library);
                isCorrectCode = true;
                break;
            }
        }
        if (!isCorrectCode){
            throw new WrongCodeException();
        }
    }

    @Override
    public boolean checkNoUsedCode(Library library) {
        List<Book> availableBookList = bookService.findAvailableBookByLibraryId(library.getId()) ;
        List<Book> allBookList = bookService.findAllBookByLibraryId(library.getId());
        return availableBookList.size() == allBookList.size();
    }


}
