package ss6_inheritance.ss6_exercise.cylinder;

import ss6_inheritance.ss6_exercise.cylinder.Cylinder;
import ss6_inheritance.ss6_practice.Circle;

public class TestCircleCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle("blue", true, 10.0);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(20);
        cylinder.setRadius(20);
        cylinder.setColor("yellow");
        cylinder.isFilled(false);
        System.out.println(cylinder.toString());
    }
}
