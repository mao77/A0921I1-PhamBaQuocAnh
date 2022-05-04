package codegym.vn.repository;

import codegym.vn.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void create(Product product);
    Product findById(int id);
    void update(Product product);
    void delete(int id);
    List<Product> findByName(String searchName);
}
