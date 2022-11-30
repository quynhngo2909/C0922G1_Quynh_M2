package case_study.student_lecturer_read_write.service;

import java.util.List;

public interface IObjectService<T> {
    void add(T o);
    void delete(T o);
    void display();

    boolean checkIDValid(String id);
    boolean checkGender(String gender);

    void write(String filePath);

    List<T> read(String filePath);
}
