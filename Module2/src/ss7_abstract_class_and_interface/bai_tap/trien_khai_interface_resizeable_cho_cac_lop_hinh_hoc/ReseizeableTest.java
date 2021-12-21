package ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class ReseizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(2, 5);
        shapes[2] = new Square(10);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                ((Circle) shape).resize(300);
                System.out.println(shape);
            } else if (shape instanceof Square) {
                ((Square) shape).resize(150);
                System.out.println(shape);
            }else {
                ((Rectangle) shape).resize(200);
                System.out.println(shape);
            }
        }
    }

//        Circle circle = (Circle) shapes[0];
//        Rectangle rectangle = (Rectangle) shapes[1];
//        circle.resize(150);
//        rectangle.resize(200);
//        System.out.println(circle);
//        System.out.println(rectangle);

    }

