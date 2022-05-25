package com.codegym.service;

import com.codegym.entity.Book;

import com.codegym.entity.Code;
import com.codegym.entity.Status;
import com.codegym.exception.NotAvailableException;
import com.codegym.exception.WrongCodeException;
import com.codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    ICodeService codeService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

        Status available = new Status(1);
        for (int i = 0; i < book.getQuantity(); i++) {
            int n = 10000 + new Random().nextInt(90000);
            Code code = new Code(n, bookRepository.findById(book.getId()).orElse(null), available);
            book.generateCode(code);
            codeService.save(code);
        }
//        bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Book book, Integer usedCode) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for (Code code : codeList) {
            if (code.getCode().equals(usedCode)) {
                code.setStatus(new Status(2, "used"));
                break;
            }
        }
        book.borrow();
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Code getNextAvailableCode(Book book) throws NotAvailableException {
        List<Code> codeList = codeService.findAvailableCodeByBookId(book.getId());
        if (codeList.size() == 0) {
            throw new NotAvailableException();
        }
        return codeList.get(0);
    }

    @Override
    public void returnBook(Book book, Integer returnCode) throws NotAvailableException, WrongCodeException {
        List<Code> codeList = codeService.findUsedCodeByBookId(book.getId());
        if (codeList.size() == 0) {
            throw new NotAvailableException();
        }

        boolean isCorrectCode = false;
        for (Code code : codeList) {
            if (code.getCode().equals(returnCode)) {
                code.setStatus(new Status(1, "available"));
                codeService.save(code);
                book.returnBook();
                bookRepository.save(book);
                isCorrectCode = true;
                break;
            }
        }
        if (!isCorrectCode) {
            throw new WrongCodeException();
        }
    }

    @Override
    public boolean checkNoUsedCode(Book book) {
        List<Code> availableCodeList = codeService.findAvailableCodeByBookId(book.getId());
        List<Code> allCodeList = codeService.findAllCodeByBookId(book.getId());
        return availableCodeList.size() == allCodeList.size();
    }
}
