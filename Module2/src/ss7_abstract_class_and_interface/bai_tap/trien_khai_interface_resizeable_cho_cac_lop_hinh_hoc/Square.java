package ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

import ss7_abstract_class_and_interface.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {

    }
    public Square(double side) {
        super(side,side);
    }
    public Square(double side, String color, boolean filled) {
        super(side,side,color,filled);
    }

    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A sqare with side = " + getSide() + ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide()*percent/100);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides...");
    }
}
