package ss5_access_modifier_static_method_static_property.bai_tap.lop_point2D_va_lop_point3D;

public class Point3D extends Point2D{
    private float z = 0.0f;
    Point3D() {

    }
    Point3D (float x, float y, float z) {
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }
    public float[] getXYZ() {
        float[] numberOfArray = new float[3];
        numberOfArray[0] = getX();
        numberOfArray[1] = getY();
        numberOfArray[2] = getZ();
        return numberOfArray;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX()+
                "; y=" + getY()+
                "; z=" + getZ()+
                '}';
    }
}
