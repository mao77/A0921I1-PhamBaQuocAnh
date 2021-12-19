package ss6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.toString());
        cylinder = new Cylinder(2,"red",5);
        System.out.println(cylinder.toString());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());
    }
}
