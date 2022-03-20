package model.responsitory;

import model.bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"cocacola",10000,"nuoc ngot","viet nam"));
        productList.add(new Product(2,"7Up",10000,"nuoc ngot","viet nam"));
        productList.add(new Product(3,"sting",10000,"nuoc ngot","viet nam"));
        productList.add(new Product(4,"huda",10000,"bia","viet nam"));
        productList.add(new Product(5,"tiger",10000,"bia","viet nam"));
        productList.add(new Product(6,"larue",10000,"bia","viet nam"));
    }
}
