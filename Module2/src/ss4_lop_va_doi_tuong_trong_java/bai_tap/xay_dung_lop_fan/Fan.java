package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Fan {
    private int speed = 1;
    private  boolean on = false;
    private double radius = 5;
    private String color = "blue";
    Fan() {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public String toString() {
        if (this.on == true) {
            return "FAN IS ON{speed: " + this.speed + ", color: " + this.color + ", radius: " + this.radius + "}";
        }else  {
            return "FAN IS OF{color: " + color + ", radius: " + radius + "}";
        }
    }
}
