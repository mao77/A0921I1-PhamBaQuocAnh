package ss2_vong_lap_trong_java.thuc_hanh;
import java.util.Scanner;
public class Kiem_tra_so_nguyen_to {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number + " không phải là số nguyên tố");
        }else {
            int i = 2;
            boolean check = true;
            while (i < number) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check == true) {
                System.out.println(number + " là số nguyên tố");
            }else {
                System.out.println(number + " không phải là số nguyên tố");
            }
        }
    }
}
