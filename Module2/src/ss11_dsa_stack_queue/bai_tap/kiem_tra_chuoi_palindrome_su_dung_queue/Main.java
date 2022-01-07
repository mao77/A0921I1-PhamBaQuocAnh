package ss11_dsa_stack_queue.bai_tap.kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi bất kì: ");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        String[] inputArray = input.split("");
        System.out.println(Arrays.toString(inputArray));
        for (String element : inputArray) {
            stack.push(element);
            queue.offer(element);
        }
        boolean result = true;
//        for (String element: stack) {
//            if (element != queue.poll()){
//                result = false;
//                break;
//            }
//        }
        while (!stack.isEmpty()) {
            if (!Objects.equals(stack.pop(), queue.poll())) {
                result = false;
                break;
            }
        }
            if (result) {
                System.out.println("Chuỗi vừa nhập là palindrome");
            } else {
                System.out.println("Chuỗi vừa nhập ko phải là palindrome");
            }
        }
    }

