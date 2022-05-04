package codegym.vn.repository;

import codegym.vn.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static final Map<Integer,Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"Nuoc Ngot","7 Up",10000,"Viet Nam"));
        products.put(2,new Product(2,"Nuoc Ngot","Pepsi",10000,"Viet Nam"));
        products.put(3,new Product(3,"Nuoc Ngot","Coca",10000,"Viet Nam"));
        products.put(4,new Product(4,"Bia","Larue",15000,"Viet Nam"));
        products.put(5,new Product(5,"Bia","Huda",15000,"Viet Nam"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        int sl = products.keySet().size();
        product.setId(sl+1);
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String searchName) {
        List<Product> searchProducts = new ArrayList<>();
        for (Product product: products.values()) {
            if (product.getName().contains(searchName)) {
                searchProducts.add(product);
            }
        }
        return searchProducts;
    }

}
