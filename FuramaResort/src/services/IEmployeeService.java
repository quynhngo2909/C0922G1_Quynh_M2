package services;

import models.Employee;

public interface IEmployeeService extends IService {
    void addNewEmployee(Employee o);
    void deleteEmployee(String deletedID);
    void editEmployee(Employee employee);
    boolean isIdUsed(String id);
    boolean isCoincidentIdentityNumber(String identityNumber);

}
