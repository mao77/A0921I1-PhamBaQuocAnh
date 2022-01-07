package ss11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Mảng sau khi đảo ngược bằng stack:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));

    }
}
