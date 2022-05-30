package com.codegym.cart_product.service;

import com.codegym.cart_product.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
