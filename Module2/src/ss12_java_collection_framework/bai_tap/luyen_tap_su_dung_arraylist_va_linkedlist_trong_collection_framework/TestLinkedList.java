package ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_va_linkedlist_trong_collection_framework;

import java.util.Scanner;

public class TestLinkedList {
    public static void main(String[] args) {
        ProductManagerLinkedList productManagerLinkedList = new ProductManagerLinkedList();
        Scanner scanner = new Scanner(System.in);
        int selection = -1;
        do {
            System.out.println("-------------MENU------------\n"
                    + "1.Thêm sản phẩm\n"
                    + "2.Hiển thị danh sách sản phẩm\n"
                    + "3.Xóa sản phẩm theo id\n"
                    + "4.Tìm kiếm sản phẩm theo tên\n"
                    + "5.Sửa thông tin sản phẩm theo id\n"
                    + "6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n"
                    + "0.Thoát"
            );
            selection = scanner.nextInt();
            if (selection == 1) {
                System.out.println("Nhập id sản phẩm:");
                int id = scanner.nextInt();
                System.out.println("Nhập tên sản phẩm:");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm:");
                double price = scanner.nextDouble();
                Product product = new Product(id, name, price);
                productManagerLinkedList.add(product);
            }else if(selection == 2) {
                productManagerLinkedList.display();
            }else if(selection == 3) {
                System.out.println("Nhập id sản phẩm cần xóa");
                int id = scanner.nextInt();
                Product product = new Product(id);
                productManagerLinkedList.delete(product);
            }else if (selection == 4) {
                System.out.println("Nhập tên sản phẩm cần tìm:");
                scanner.nextLine();
                String name = scanner.nextLine();
                productManagerLinkedList.find(name);
            }else if (selection == 5) {
                System.out.println("Nhập vào id của sản phẩm muốn sửa:");
                int id = scanner.nextInt();
                productManagerLinkedList.edit(id);
            }else if (selection ==6) {
                productManagerLinkedList.sortAscending();
            }
        } while (selection != 0);
    }
}