package ss6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle{
    private double height = 1.0;

    Cylinder() {
        super();
    }

    Cylinder(double radius, String color,double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    protected double getArea() {
        return 2 * Math.PI * getRadius() * (getRadius()+getHeight());
    }

    @Override
    public String toString() {
        return "A cylinder with height = " + getHeight() + ", which a subclass of " + super.toString();
    }
    protected double getVolume() {
        return super.getArea() * getHeight();
    }
}
