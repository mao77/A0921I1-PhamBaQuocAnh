package ss6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "green";

    Circle () {

    }
    Circle (double radius, String color) {
        this.color = color;
        this.radius =radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    protected double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + getRadius() + ", which color is " + getColor();
    }
}
