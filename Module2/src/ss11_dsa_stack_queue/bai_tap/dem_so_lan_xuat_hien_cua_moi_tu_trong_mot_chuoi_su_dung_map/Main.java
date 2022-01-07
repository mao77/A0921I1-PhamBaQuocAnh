package ss11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_moi_tu_trong_mot_chuoi_su_dung_map;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 từ:");
        String input = scanner.nextLine();
        String[] inputArray = input.split("");
        System.out.println(Arrays.toString(inputArray));
        for (String key : inputArray) {
            if (treeMap.containsKey(key)) {
                int value = treeMap.get(key);
                treeMap.put(key, ++value);
            } else {
                treeMap.put(key, 1);
            }
        }
        System.out.println("Số lần xuất hiện của:");
        for (String element : treeMap.keySet()) {
            System.out.println(element + ": " + treeMap.get(element));
        }
    }
}
