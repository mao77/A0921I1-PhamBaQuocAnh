package com.codegym.book_management.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {
    }

    public Book(String code, boolean status, Library library) {
        this.code = code;
        this.status = status;
        this.library = library;
    }

    public Book(String code, Library library) {
        this.code = code;
        this.library = library;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
