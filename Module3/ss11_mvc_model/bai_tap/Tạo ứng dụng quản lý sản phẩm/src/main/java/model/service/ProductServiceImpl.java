package model.service;

import model.bean.Product;
import model.responsitory.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService{
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(ProductRepository.productList);
    }

    @Override
    public void save(Product product) {
        ProductRepository.productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return ProductRepository.productList.get(id);
    }

    @Override
    public void update(int id,String name,float price,String description,String producer) {
       ProductRepository.productList.get(id).setName(name);
       ProductRepository.productList.get(id).setPrice(price);
       ProductRepository.productList.get(id).setDescription(description);
       ProductRepository.productList.get(id).setProducer(producer);

    }

    @Override
    public void remove(int id) {
        ProductRepository.productList.remove(id);
    }
}
