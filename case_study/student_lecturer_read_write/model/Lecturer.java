package case_study.student_lecturer.model;

public class Lecturer extends Person{
    private String expertise;

    public Lecturer() {
    }

    public Lecturer(String id, String name, String gender, String expertise) {
        super(id, name, gender);
        this.expertise = expertise;
    }

    public Lecturer(String deleteID) {
        super.setId(deleteID);
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                "expertise='" + expertise + '\'' +
                '}';
    }
}
