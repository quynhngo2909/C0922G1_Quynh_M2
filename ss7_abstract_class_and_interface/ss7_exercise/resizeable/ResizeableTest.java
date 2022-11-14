package ss7_abstract_class_and_interface.ss7_exercise.interface_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10,20);
        shapes[2] = new Square(30);

        System.out.println("Before resized");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }

        double resizePercent = (Math.random() * ( 100 - 1) + 1) + 1;
        System.out.println("Resizeable percent:" + resizePercent);

        System.out.println("After resized");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Resizeable resizeable = (Circle) shape;
                resizeable.resize(resizePercent);
            } else if (shape instanceof Rectangle) {
                Resizeable resizeable = (Rectangle) shape;
                resizeable.resize(resizePercent);
            } else {
                Resizeable resizeable = (Square) shape;
                resizeable.resize(resizePercent);
            }
            System.out.println(shape.getArea());
        }
    }
}
