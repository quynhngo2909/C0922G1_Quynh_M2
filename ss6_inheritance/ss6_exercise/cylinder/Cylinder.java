package ss6_inheritance.ss6_exercise.cylinder;

import ss6_inheritance.ss6_practice.Circle;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder(){
    }


    public Cylinder(String color, boolean filled, double radius, double height) {
        super(color, filled, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea() * height;
    }

    public String toString() {
        return "A Cylinder with height = " + getHeight() + ", which is a subclass Circle." + super.toString();
    }
}
