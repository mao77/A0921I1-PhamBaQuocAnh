package ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_va_linkedlist_trong_collection_framework;

import java.util.*;

public class ProductManager {
    List<Product> arrayList = new ArrayList<Product>();

//    public ProductManager() {
//        this.arrayList = new ArrayList<Product>();
//    }

    //    1.Thêm sản phẩm
    public void add(Product product) {
        this.arrayList.add(product);
    }

    //    2.Hiển thị danh sách sản phẩm
    public void display() {
        for (Product product : arrayList) {
            System.out.println(product);
        }
    }

    //     3.Xóa sản phẩm theo id
    public void delete(Product product) {
        this.arrayList.remove(product);
    }

    //         4.Tìm kiếm sản phẩm theo tên
    public void find(String name) {
        for (Product product : arrayList) {
//            if (product.getName().contains(name)) {
            if (product.getName().indexOf(name) >= 0) {
                System.out.println(product);
            }
        }
    }

    //    5.Sửa thông tin sản phẩm theo id
    public void edit(int id) {
        Scanner scanner = new Scanner(System.in);
        for (Product product : arrayList) {
            if (product.getId() == id) {
                String name;
                double price;
                System.out.println("Nhập tên sản phẩm có id = " + id);
                name = scanner.nextLine();
                product.setName(name);
                System.out.println("Nhập giá sản phẩm có id = " + id);
                price = scanner.nextDouble();
                product.setPrice(price);
            }
        }
    }

    //    6.Sắp xếp sản phẩm tăng, giảm dần theo giá
    public void  sortAscending() {
        Collections.sort(this.arrayList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getPrice() < product2.getPrice()) {
                    return -1;
                } else if (product1.getPrice() > product2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void sortDescending() {
        Collections.sort(this.arrayList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getPrice() > product2.getPrice()) {
                    return -1;
                } else if (product1.getPrice() < product2.getPrice()) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
    }

}
