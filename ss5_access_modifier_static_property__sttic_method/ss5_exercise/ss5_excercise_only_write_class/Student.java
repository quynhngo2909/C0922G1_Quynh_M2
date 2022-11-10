package ss5_access_modifier_static_property__sttic_method.ss5_exercise.ss5_excercise_only_write_class;

public class Student {
    private String name = "John";
    private String classes ="C02";

    public Student() {
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }
}
