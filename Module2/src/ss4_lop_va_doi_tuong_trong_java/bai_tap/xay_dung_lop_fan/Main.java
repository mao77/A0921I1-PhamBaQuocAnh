package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setColor("yellow");
        fan1.setRadius(10);
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan2.setSpeed(2);


        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
