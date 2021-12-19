package ss6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Square extends Retangle{
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
}
