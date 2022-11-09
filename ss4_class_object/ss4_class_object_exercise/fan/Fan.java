package ss4_class_object.fan;

import java.util.Scanner;

public class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {

    }

    int getSpeed() {
        return this.speed;
    }

    boolean getOn() {
        return this.on;
    }

    double getRadius() {
        return this.radius;
    }

    String getColor() {
        return this.color;
    }

    void setSpeed(int a) {
        this.speed = a;
    }

    void turnOff() {
        this.on = false;
    }

    void turnOn() {
        this.on = true;
    }

    void setRadius(double newRadius) {
        Scanner sc = new Scanner(System.in);
        while (newRadius <= 0) {
            System.out.println("Radius has to be bigger than 0. Input new radius ");
            newRadius = Double.parseDouble(sc.nextLine());
        }
        this.radius = newRadius;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    public String toString() {
        if (this.getOn()) {
            return "Fan is on: speed is " + speed + ", radius is " + radius + ", color is " + color;
        } else {
            return "Fan is off: radius is " + radius + ", color is " + color;
        }
    }

}
