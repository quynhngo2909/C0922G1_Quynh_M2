package ss4_class_object.ss4_class_object_exercise.solve_quadractic_equation;

public class QuadraticEquation {
    double a, b, c;
    public QuadraticEquation() {
    }
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-(this.b) + Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

    public double getRoot2() {
        return (-(this.b) - Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

   public String display() {
        if (this.a == 0) {
            if (this.b == 0) {
                if (this.c != 0) {
                    return "This equation has no real roots";
                } else {
                    return "This equation has infinity roots";
                }
            }else {
                return "This equation has one root: " + (-this.c / this.b);
            }
        } else {
            if (getDiscriminant() < 0) {
                return "This equation has no real roots";
            } else if (getDiscriminant() == 0) {
                return "This equation has one root: " + getRoot1();
            } else {
                return "This equation has two roots: " + getRoot1() + " and " + getRoot2();
            }
        }
    }
}
