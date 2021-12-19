package ss5_access_modifier_static_method_static_property.bai_tap.lop_point2D_va_lop_point3D;

public class point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        point3D = new Point3D(1, 1, 1);
        System.out.println(point3D.toString());
        point3D.setX(4);
        point3D.setY(3);
        point3D.setZ(2);
        System.out.println(point3D);
        for (int i = 0; i < point3D.getXYZ().length; i++) {
            System.out.print(point3D.getXYZ()[i] + "\t");
        }
    }
}
