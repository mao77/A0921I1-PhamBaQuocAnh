package ss2_vong_lap_trong_java.bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100:");
        for (int i = 3; i < 100; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = false;
                }
            }
            if (check == true) {
                System.out.println(i);
            }
        }
    }
}
