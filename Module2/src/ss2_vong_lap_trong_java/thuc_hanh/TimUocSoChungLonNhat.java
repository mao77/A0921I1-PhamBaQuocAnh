package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimUocSoChungLonNhat {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Input a: ");
        a = input.nextInt();
        System.out.println("Input b: ");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("Không có ước số chung");
        }else {
            while (a != b) {
                if (a > b){
                    a = a - b;
                }else b = b -a;
            }
        }
        System.out.println("Ước số chung lớn nhất là: " + a);


    }
}
