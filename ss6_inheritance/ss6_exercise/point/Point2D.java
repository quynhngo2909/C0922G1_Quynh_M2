package ss6_inheritance.ss6_exercise.point;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
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

    public float[] getXY(){
        float[] arrayXY = {getX(), getY()};
        return arrayXY;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "A Point2D is at " + Arrays.toString(getXY());
    }
}
