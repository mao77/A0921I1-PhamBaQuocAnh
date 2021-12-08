package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class Hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Nhập chiều dài hình chữ nhật:");
                    int chieuDai = input.nextInt();
                    System.out.println("Nhập chiều rộng hình chữ nhật:");
                    int chieuRong = input.nextInt();
                    for (int i = 0; i < chieuRong; i++) {
                        for (int j = 0; j <chieuDai; j++) {
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle ");
                    System.out.println("Nhập chiều cao:");
                    int chieuCao = input.nextInt();

                    for (int i = 0; i < chieuCao; i++) {
                        for (int j = 0; j < i; j++) {
                             System.out.print("*");
                        }
                        System.out.print("\n");
                    }

                    break;
                case 3:
                    System.out.println("Draw the rectangle");

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}
