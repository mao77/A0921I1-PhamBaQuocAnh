package ss5_access_modifier_static_method_static_property.bai_tap.lop_point2D_va_lop_point3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    Point2D() {

    }

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        float[] arrayOfXY = new float[2];
        arrayOfXY[0] = this.x;
        arrayOfXY[1] = this.y;
        return arrayOfXY;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
