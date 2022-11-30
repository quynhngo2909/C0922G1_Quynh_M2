package case_study.student_lecturer_read_write.service.impl;

import case_study.student_lecturer.model.Gender;
import case_study.student_lecturer.model.Student;
import case_study.student_lecturer_read_write.service.IObjectServiceIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService implements IObjectServiceIO<Student> {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student o) {
        studentList.add(o);
    }

    @Override
    public void delete(Student o) {
        for (Student lecturer : studentList) {
            if (Objects.equals(o.getId(), lecturer.getId())) {
                studentList.remove(lecturer);
                break;
            }
        }
    }

    @Override
    public void display() {
        for (Student lecturer : studentList) {
            System.out.println(lecturer.toString());
        }
    }

    @Override
    public boolean checkIDValid(String id) {
        boolean checkIDValid = false;
        for (Student lecturer : studentList) {
            if (id.equals(lecturer.getId())) {
                checkIDValid = true;
                break;
            }
        }
        return checkIDValid;
    }

    @Override
    public boolean checkGender(String gender) {
        gender = gender.toUpperCase();
        boolean checkGender = false;
        for (Gender gd : Gender.values()) {
            if (gender.equals(gd.name())) {
                checkGender = true;
                break;
            }
        }
        return checkGender;
    }

    @Override
    public void write(String filePath, List<Student> students) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < ; i++) {
                
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> read(String filePath, List<Student> tlist) {
        return null;
    }

    public boolean checkScore(float score) {
        return !(score < 0) && !(score > 10);
    }
}
