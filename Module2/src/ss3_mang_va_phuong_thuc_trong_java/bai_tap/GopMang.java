package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng a:");
        int numberOfElement = scanner.nextInt();
        int[] a = new int[numberOfElement];
        declareArray(a);
        display(a);
        System.out.println("\nNhập số phần tử của mảng b:");
        numberOfElement = scanner.nextInt();
        int[] b = new int[numberOfElement];
        declareArray(b);
        display(b);
        int[] c = new int[a.length + b.length];
        merge(a,b,c);
        display(c);

    }

    public static void declareArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập giá trị phần tử số " + (i + 1) + ":");
            array[i] = scanner.nextInt();
        }
    }

    public static void display(int[] array) {
        System.out.println("Mảng vừa khởi tạo: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void merge(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length ; i++) {
            c[i] = a[i];
        }
        for (int j = a.length; j < c.length ; j++) {
            c[j] = b[j - a.length];
        }
    }


}
