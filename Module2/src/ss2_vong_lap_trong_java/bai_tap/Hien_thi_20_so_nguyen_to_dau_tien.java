package ss2_vong_lap_trong_java.bai_tap;

public class Hien_thi_20_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        System.out.println("20 số nguyên tố đầu tiên:");
        int num = 3;
        int count = 0;
        while (count <= 20) {
            boolean check = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) check = false;
            }
            if (check == true) {
                count++;
                System.out.println(count + ". " + num);
            }
            num++;
        }
    }
}
