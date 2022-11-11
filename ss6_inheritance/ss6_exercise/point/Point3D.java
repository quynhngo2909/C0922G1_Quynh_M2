package ss6_inheritance.ss6_exercise.point;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arrayXYX = {super.getX(), super.getY(), getZ()};
        return arrayXYX;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        this.z = z;
    }

    public String toString() {
        return "A Point3D is at " + Arrays.toString(getXYZ());
    }
}
