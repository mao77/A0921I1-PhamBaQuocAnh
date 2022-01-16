package ss15_xu_ly_ngoai_le_debug.thuc_hanh.su_dung_lop_arrayindexoutofboundsexception;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        System.out.println("Vui lòng nhập chỉ số của 1 phần tử:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử số " + x + " là: " + arr[x-1]);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng:");
        for (int i =0; i<100;i++){
            arr[i] = rd.nextInt(100);
            System.out.println(arr[i] +  " ");
        }
        return arr;
    }
}
