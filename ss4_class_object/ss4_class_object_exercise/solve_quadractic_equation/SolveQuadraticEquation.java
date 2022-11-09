package ss4_class_object.ss4_class_object_exercise.solve_quadractic_equation;

import java.util.Scanner;

public class SolveQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Solve quadratic equation:");
        System.out.println("Enter a:");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Enter b:");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Enter c:");
        double c = Double.parseDouble(sc.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("a, b, c : " +
                quadraticEquation.getA() + ", " + quadraticEquation.getB() + ", " + quadraticEquation.getC() + " :");
        System.out.println(quadraticEquation.display());
    }
}
