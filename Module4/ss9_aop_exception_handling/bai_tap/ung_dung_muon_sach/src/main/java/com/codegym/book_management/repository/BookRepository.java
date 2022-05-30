package com.codegym.book_management.repository;

import com.codegym.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByLibraryId(int id);
    List<Book> findBookByLibrary_IdAndStatus(int bookId, boolean status);
    List<Book> findAvailableBookByLibraryId(int id);
}
