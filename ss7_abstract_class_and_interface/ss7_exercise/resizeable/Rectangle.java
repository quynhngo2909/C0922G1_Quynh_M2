package ss7_abstract_class_and_interface.ss7_exercise.interface_resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, String filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public void resize(double percent) {
        this.width = this.width * Math.sqrt(percent / 100 + 1);
        this.height = this.height * Math.sqrt(percent / 100 + 1);
    }
}
