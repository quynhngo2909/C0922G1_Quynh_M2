package ss6_inheritance.ss6_exercise.point;

public class TestPoint2DPoint3D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D.setXY(2,2);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D.setXYZ(1,2,3);
        System.out.println(point3D);
    }
}
