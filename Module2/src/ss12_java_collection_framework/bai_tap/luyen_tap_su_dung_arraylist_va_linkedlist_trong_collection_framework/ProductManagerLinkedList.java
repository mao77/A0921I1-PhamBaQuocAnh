package ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_va_linkedlist_trong_collection_framework;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerLinkedList {
    LinkedList<Product> linkedList = new LinkedList<Product>();

    //    1.Thêm sản phẩm
    public void add(Product product) {
        linkedList.add(product);
    }

    //    2.Hiển thị danh sách sản phẩm
    public void display() {
        for (Product product : linkedList) {
            System.err.println(product);
        }
    }

    //     3.Xóa sản phẩm theo id
    public void delete(Product product) {
        linkedList.remove(product);
    }

    //    4.Tìm kiếm sản phẩm theo tên
    public void find(String name) {
        for (Product product : linkedList) {
            if (product.getName().contains(name)) {
                System.err.println(product);
            }
        }
    }

    //    5.Sửa thông tin sản phẩm theo id
    public void edit(int id) {
        for (Product product : linkedList){
            if (id == product.getId()){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập tên sản phẩm cần sửa:");
                product.setName(scanner.nextLine());
                System.out.println("Nhập giá sản phẩm cần sửa:");
                product.setPrice(scanner.nextDouble());

            }
        }
    }
//    6.Sắp xếp sản phẩm tăng, giảm dần theo giá
    public void sortAscending(){
        Collections.sort(linkedList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getPrice() < product2.getPrice()){
                    return -1;
                }else if (product1.getPrice()>product2.getPrice()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
    }
}
