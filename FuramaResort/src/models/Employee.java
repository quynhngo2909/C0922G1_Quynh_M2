package models;

import libs.EmployeePosition;
import libs.EmployeeQualification;

import java.time.LocalDate;


public class Employee extends Person {
    private String qualification;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String fullName, LocalDate birthday, String gender, String identityNumber, String phoneNumber,
                    String email, String qualification, String position, double salary) {
        super(id, fullName, birthday, gender, identityNumber, phoneNumber, email);
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public boolean setQualification(String qualification) {
        qualification = qualification.toUpperCase();
        for (EmployeeQualification emplQual : EmployeeQualification.values()) {
            if (qualification.equals(emplQual.name())) {
                this.qualification = qualification;
                return true;
            }
        }
        return false;
    }

    public String getPosition() {
        return position;
    }

    public boolean setPosition(String position) {
        position = position.toUpperCase();
        for (EmployeePosition emplPos : EmployeePosition.values()) {
            if (position.equals(emplPos.name())) {
                this.position = position;
                return true;
            }
        }
        return false;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " id='" + super.getId() + '\'' +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthday=" + super.getBirthdayString() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", identityNumber='" + super.getIdentityNumber() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} ";
    }

    public String convertToCSVFormat() {
        return  super.getId() + ',' +
                super.getFullName() + ',' +
                super.getBirthdayString() + ',' +
                super.getGender() + ',' +
                super.getIdentityNumber() + ',' +
                super.getPhoneNumber() + ',' +
                super.getEmail() + ',' +
                qualification + ',' +
                position + ',' +
                salary;
    }
}
