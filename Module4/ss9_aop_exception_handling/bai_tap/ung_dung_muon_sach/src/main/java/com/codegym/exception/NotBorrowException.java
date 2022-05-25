package com.codegym.exception;

public class NotBorrowException extends Exception {
    @Override
    public String getMessage() {
        return "No book is borrowed";
    }
}
