package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa nhập:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        int max_index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max_index]) {
                max_index = i;
            }
        }
        System.out.println("\nGiá trị lớn nhất trong mảng là: " + array[max_index]);
    }

}
