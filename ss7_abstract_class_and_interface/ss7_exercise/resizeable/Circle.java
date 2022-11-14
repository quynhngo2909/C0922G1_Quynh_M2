package ss7_abstract_class_and_interface.ss7_exercise.interface_resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, String filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public void resize(double percent) {
      this.radius = this.radius * Math.sqrt(percent / 100 + 1);
    }
}
