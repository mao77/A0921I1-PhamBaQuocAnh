package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr;
        int x,y;
        System.out.println("Nhập số hàng của ma trận muốn khởi tạo:");
        x = scanner.nextInt();
        System.out.println("Nhập số cột của ma trận muốn khởi tạo:");
        y = scanner.nextInt();
        arr = new int[x][y];
        clareArray(arr);
        display(arr);
        System.out.println("Giá trị lớn nhất trong mảng là: " + FindMaxElement(arr));
    }

    public static int FindMaxElement(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    public static void clareArray(int[][] arr){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập giá trị phần tử tại vị trí ["+(i+1)+"]["+(j+1)+"]:");
                arr[i][j] = scanner.nextInt();
            }
        }
    }
    public static void display(int[][] arr) {
        System.out.println("Mảng vừa nhập:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}

