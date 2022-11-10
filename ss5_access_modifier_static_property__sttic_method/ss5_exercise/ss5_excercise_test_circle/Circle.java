package ss5_access_modifier_static_property__sttic_method.ss5_exercise;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public  Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }

    protected String getColor() {
        return color;
    }
}
