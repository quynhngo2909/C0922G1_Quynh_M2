package case_study.student_lecturer.model;

public class Student extends Person{
    private String studentClass;
    private float score;
    

    public Student(String id, String name, String gender, String studentClass, float score) {
        super(id, name, gender);
        this.studentClass = studentClass;
        this.score = score;
    }

    public Student(String deleteID) {
        super.setId(deleteID);
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                "studentClass='" + studentClass + '\'' +
                ", score=" + score +
                '}';
    }
}
