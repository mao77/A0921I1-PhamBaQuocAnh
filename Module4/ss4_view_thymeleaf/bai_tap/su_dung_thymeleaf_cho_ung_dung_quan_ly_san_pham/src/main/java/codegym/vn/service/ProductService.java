package codegym.vn.service;

import codegym.vn.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    Product findById(int id);
    void update(Product product);
    void delete(int id);
}
