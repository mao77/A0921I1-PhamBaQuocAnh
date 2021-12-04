package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class Ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Nhập giá trị usd cần đổi sang vnd: ");
        double usd = scanner.nextDouble();
        double vnd = usd * rate;
        System.out.println(usd + " usd = " + vnd + " vnd");
    }
}
