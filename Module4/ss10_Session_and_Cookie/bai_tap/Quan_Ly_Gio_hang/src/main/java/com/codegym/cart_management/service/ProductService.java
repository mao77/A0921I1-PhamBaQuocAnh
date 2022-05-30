package com.codegym.cart_management.service;

import com.codegym.cart_management.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void add(Product product);
    void delete(Product product);
}
