package ss6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Retangle extends Shape{
    private double width = 1.0;
    private double length = 1.0;

    public Retangle() {

    }
    public Retangle(double width,double length) {
        this.width = width;
        this.length = length;
    }
    public Retangle(double width, double length,String color,boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "A rectangle with width = " + getWidth() + " and length = " + getLength() + ", which a subclass of " + super.toString();
    }
}
