package ss11_dsa_stack_queue.bai_tap.kiem_tra_dau_ngoac_trong_bieu_thuc_su_dung_stack;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào biểu thức cần kiểm tra:");
        String input = scanner.nextLine();
        String[] inputArray = input.split("");
        System.out.println(checkBrackets(inputArray));

    }

    public static boolean checkBrackets(String[] input) {

        Stack<String> bStack = new Stack<String>();
        for (String element : input) {
            if (Objects.equals(element, "(")) {
                bStack.push(element);
            }else if (Objects.equals(element, ")") && !bStack.isEmpty()) {
                bStack.pop();
            }else if (Objects.equals(element, ")") && bStack.isEmpty()){
                return false;
            }
        }
        if (bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
