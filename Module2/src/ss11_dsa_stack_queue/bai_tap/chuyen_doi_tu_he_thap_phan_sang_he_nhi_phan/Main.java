package ss11_dsa_stack_queue.bai_tap.chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên:");
        int number = scanner.nextInt();
        System.out.print("Giá trị nhị phân của " + number + " là: ");
        while (number > 0) {
            int surPlus = number % 2;
            stack.push(surPlus);
            number = number / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
