package ss6_ke_thua.bai_tap.lop_point_va_move_ablepoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;
    Point() {

    }
    Point(float x, float y) {
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
        float[] numberOfArray= new float[2];
        numberOfArray[0] = getX();
        numberOfArray[1] = getY();
        return numberOfArray;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
