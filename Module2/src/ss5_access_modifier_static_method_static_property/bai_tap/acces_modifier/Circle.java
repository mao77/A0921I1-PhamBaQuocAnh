package ss5_access_modifier_static_method_static_property.bai_tap.acces_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }
    Circle (double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return this.radius;
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

    protected double getArea () {
        return this.radius * this.radius * Math.PI;
    }

    }

