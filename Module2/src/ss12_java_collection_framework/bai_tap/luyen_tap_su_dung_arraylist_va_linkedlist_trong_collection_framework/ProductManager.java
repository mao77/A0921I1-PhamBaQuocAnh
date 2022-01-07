package ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_va_linkedlist_trong_collection_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    List<Product> arrayList = new ArrayList<Product>();

    //    1.Thêm sản phẩm
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        arrayList.add(product);
    }

//    2.Hiển thị danh sách sản phẩm
    public Product display(){

    }

}
