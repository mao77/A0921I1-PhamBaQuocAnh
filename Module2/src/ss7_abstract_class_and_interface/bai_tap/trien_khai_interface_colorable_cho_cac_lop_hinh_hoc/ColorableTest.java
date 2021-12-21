package ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

import ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Circle;
import ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Rectangle;
import ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Shape;
import ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(2,2);
        shapes[2] = new Square(3);
        shapes[3] = new Circle(2);
        shapes[4] = new Rectangle(5,5);
        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }else if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
            }else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());
            }
        }
    }
}
