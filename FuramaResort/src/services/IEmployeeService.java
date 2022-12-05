package services;

import java.text.ParseException;

public interface IEmployeeService extends IService {
    @Override
    void displayList();
    void addNewEmployee();
    void deleteEmployee();
    void editEmployee();
}
