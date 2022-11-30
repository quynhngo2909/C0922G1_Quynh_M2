package ss18_regex.exercise.class_name_validate;

public class ClassNameTest {
    private static ClassNameExample classNameExample;
    public static final String[] validClassName = new String[] { "C0318G", "C0922G"};
    public static final String[] invalidClassName = new String[] { "M0318G", "P0323A"};

    public static void main(String[] args) {
        classNameExample = new ClassNameExample();
        for (String className : validClassName) {
            boolean isValid = classNameExample.validateClassName(className);
            System.out.println("Class name " + className + " is valid: " + isValid);
        }

        for (String className : invalidClassName) {
            boolean isValid = classNameExample.validateClassName(className);
            System.out.println("Class name " + className + " is valid: " + isValid);
        }
    }
}
