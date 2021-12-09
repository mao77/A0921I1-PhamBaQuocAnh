package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_QuadraticEquation;

public class QuadraticEquation {
    private double a, b, c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (2 * this.b) - (4 * a * c);
    }

    public double getRoot1() {
        double result;
        result = (-this.b + Math.pow(((this.b * this.b) - (4 * this.a * this.c)),0.5)) / (2 * this.a);
        return result;
    }
    public double getRoot2() {
        double result;
        result = (-this.b - Math.pow(((this.b * this.b) - (4 * this.a * this.c)),0.5)) / (2 * this.a);
        return result;
    }
}
