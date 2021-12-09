package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfElement;
        System.out.println("Nhập số lượng phần tử của mảng:");
        numOfElement = scanner.nextInt();
        int[] array = new int[numOfElement];
        //Khởi tạo hàm
        declareArray(array);
        System.out.println("Mảng vừa nhập:");
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\nNhập giá trị cần thêm: ");
        int num = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn(1-->" + numOfElement + ")");
        int index = scanner.nextInt();
        insertElement(array, index, num);
        System.out.println("Mảng sau khi chèn: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }

    }

    public static void declareArray(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhập giá trị phần tử số " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
    }

    public static void insertElement(int[] arr, int index, int num) {
        for (int i = arr.length - 1; i > index-1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index-1] = num;
    }
}
