package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a:");
        a = scanner.nextDouble();
        System.out.println("Input b:");
        b = scanner.nextDouble();
        System.out.println("Input c:");
        c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double discriminant = quadraticEquation.getDiscriminant();
        if (discriminant >= 0) {
            if (discriminant == 0) {
                System.out.println("The equation has one root: x = " + quadraticEquation.getRoot1());
            }else System.out.println("The equation has two root: x1 = " + quadraticEquation.getRoot1() + ", x2 = " + quadraticEquation.getRoot2());
        }else System.out.print("The equation has no real roots!");
    }
}
