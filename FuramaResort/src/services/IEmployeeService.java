package services;

import models.Employee;
import models.Person;

import java.text.ParseException;

public interface IEmployeeService extends IService {
    void addNewEmployee(Employee o);
    void deleteEmployee(String deletedID);
    void editEmployee(String editedID);
}
