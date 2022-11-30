package case_study.student_lecturer_read_write.service.impl;

import case_study.student_lecturer_read_write.model.Gender;
import case_study.student_lecturer_read_write.model.Lecturer;
import case_study.student_lecturer_read_write.service.IObjectServiceIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LecturerService implements IObjectServiceIO<Lecturer> {
    private static List<Lecturer> lecturerList = new ArrayList<>();

    @Override
    public void add(Lecturer o) {
        lecturerList.add(o);
    }

    @Override
    public void delete(Lecturer o) {
        for (Lecturer lecturer : lecturerList) {
            if (Objects.equals(o.getId(), lecturer.getId())) {
                lecturerList.remove(lecturer);
                break;
            }
        }
    }

    @Override
    public void display() {
        for (Lecturer lecturer : lecturerList) {
            System.out.println(lecturer.toString());
        }
    }

    @Override
    public boolean checkIDValid(String id) {
        boolean checkIDValid = false;
        for (Lecturer lecturer : lecturerList) {
            if (id.equals(lecturer.getId())) {
                checkIDValid = true;
                break;
            }
        }
        return checkIDValid;
    }

    @Override
    public void writeFile(String filePath, List<Lecturer> lecturers) {

    }

    @Override
    public List<Lecturer> readFile(String filePath) {
        return null;
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


}
