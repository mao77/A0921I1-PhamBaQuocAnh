package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id,String name ,float price,String description,String producer);

    void remove(int id);
}
