package ss6_ke_thua.bai_tap.lop_point_va_move_ablepoint;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    MovablePoint() {
    }

    MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speedArray = new float[2];
        speedArray[0] = getxSpeed();
        speedArray[1] = getySpeed();
        return speedArray;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", xSpeed=" + getxSpeed() +
                ", ySpeed=" + getySpeed() +
                '}';
    }
    public MovablePoint move() {
        setX(this.xSpeed + getX());
        setY(this.ySpeed + getY());
        return this;
    }
}
