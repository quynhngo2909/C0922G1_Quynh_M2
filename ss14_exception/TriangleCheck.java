package ss14_exception;

public class TriangleCheck {

    public void checkTriangleEdges (double edge1, double edge2, double edge3) throws IllegalTriangleException {
        if (edge1 < 0 || edge2 < 0 || edge3 < 0) {
            throw new IllegalTriangleException("Triangle edges must be positive numbers");
        } else if (edge1 >= edge2 + edge3 || edge2 >= edge1 + edge3 || edge3 >= edge1 + edge2) {
            throw new IllegalTriangleException("Sum of 2 triangle edges must be bigger than the last triangle edge");
        } else {
            System.out.println("The triangle is valid");
        }
    }
}
