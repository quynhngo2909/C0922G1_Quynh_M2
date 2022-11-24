package ss14_exception;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);
        TriangleCheck check = new TriangleCheck();
        System.out.println("Input triangle edges:");
        double edge1;
        double edge2;
        double edge3;

        do {
            try {
                edge1 = Double.parseDouble(sc.nextLine());
                edge2 = Double.parseDouble(sc.nextLine());
                edge3 = Double.parseDouble(sc.nextLine());
                check.checkTriangleEdges(edge1, edge2, edge3);
                break;
            } catch (IllegalTriangleException e) {
                System.err.println("Triangle edges must be positive numbers & " +
                        "Sum of 2 triangle edges must be bigger than the last triangle edge");
            } catch (NumberFormatException e) {
                System.err.println("Triangle edges must be numbers");
            }
        } while (true);
    }
}