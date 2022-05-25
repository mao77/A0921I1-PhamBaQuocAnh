package com.codegym.service;



import com.codegym.entity.Book;
import com.codegym.entity.Code;
import com.codegym.exception.NotAvailableException;
import com.codegym.exception.WrongCodeException;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();
    Code findById(Integer id);

    void save(Code code);

    List<Code> findAllCodeByBookId(Integer id);

    List<Code> findAvailableCodeByBookId(Integer id);

    List<Code> findUsedCodeByBookId(Integer id);

    void returnBookByCode(Book book, Integer returnCode);




}
