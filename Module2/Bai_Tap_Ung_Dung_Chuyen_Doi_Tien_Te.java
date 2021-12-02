package ss1;

import java.util.Scanner;

public class Bai_Tap_Ung_Dung_Chuyen_Doi_Tien_Te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Nhập giá trị usd cần đổi sang vnd: ");
        double usd = scanner.nextDouble();
        double vnd = usd * rate;
        System.out.println(usd + " usd = " + vnd + " vnd");
    }
}
