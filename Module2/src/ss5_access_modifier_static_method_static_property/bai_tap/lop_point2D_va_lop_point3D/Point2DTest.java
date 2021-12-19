package ss5_access_modifier_static_method_static_property.bai_tap.lop_point2D_va_lop_point3D;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setXY(2,5);
        for (int i = 0; i < point2D.getXY().length;i++) {
            System.out.println(point2D.getXY()[i]);
        }
        System.out.println(point2D.toString());
    }
}
