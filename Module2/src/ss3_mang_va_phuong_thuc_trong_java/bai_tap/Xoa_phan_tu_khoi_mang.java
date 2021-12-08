package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Mảng array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        Scanner scanner = new Scanner(System.in);

        boolean check = false;

        do {
            System.out.println("Nhập phần tử cần xóa:");
            int del_element = scanner.nextInt();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == del_element) {
                    check = true;
                    for (int j = i; j < array.length-1; j++) {
                        array[j] = array [j + 1];
                    }
                }
            }

        } while (check == false);
        System.out.println("Mảng sau khi xóa: ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
