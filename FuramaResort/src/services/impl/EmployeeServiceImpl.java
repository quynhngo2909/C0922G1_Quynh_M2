package services.impl;

import libs.EmployeePosition;
import libs.EmployeeQualification;
import libs.Gender;
import models.Employee;
import services.IEmployeeService;
import utils.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    @Override
    public void displayList() {
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void addNewEmployee() {
        String id;
        do {
            System.out.println("Input id for the new employee");
            id = sc.nextLine();
        } while (isIdUsed(id));

        String fullName;
        System.out.println("Input the new employee's full name");
        fullName = sc.nextLine();
        LocalDate birthday;
        System.out.println("Input the new employee's birthday");
        birthday = Regex.validateUserAge(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        String gender;
        do {
            System.out.println("Input the new employee's gender");
            gender = sc.nextLine();
        } while (!isGenderValid(gender));

        String identityNumber;
        do {
            System.out.println("Input the new employee's identityNumber");
            identityNumber = sc.nextLine();
        } while (isCoincidentIdentityNumber(identityNumber));

        String phoneNumber;
        System.out.println("Input the new employee's phone number");
        phoneNumber = sc.nextLine();
        String email;
        System.out.println("Input the new employee's email");
        email = sc.nextLine();
        String qualification;
        do {
            System.out.println("Input the new employee's qualification");
            qualification = sc.nextLine();
        } while (!isQualificationValid(qualification));

        String position;
        do {
            System.out.println("Input the new employee's position");
            position = sc.nextLine();
        } while (!isPositionValid(position));

        double salary;
        System.out.println("Input the new employee's salary");
        salary = Double.parseDouble(sc.nextLine());

        employeeList.add(new Employee(id, fullName, birthday, gender, identityNumber, phoneNumber, email, qualification,
                position, salary));
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Please input employee's id");
        String deletedId = sc.nextLine();
        if (!isIdUsed(deletedId)) {
            System.out.println("The id " + deletedId + " is not exit in employee list.");
        } else {
            for (Employee e : employeeList) {
                if (deletedId.equals(e.getId())) {
                    employeeList.remove(e);
                    break;
                }
            }
        }
    }

    @Override
    public void editEmployee() {
        System.out.println("Please input employee's id for editing");
        String editedId = sc.nextLine();
        if (!isIdUsed(editedId)) {
            System.out.println("The id " + editedId + " is not exit in employee list.");
        } else {
            for (Employee e : employeeList) {
                if (editedId.equals(e.getId())) {
                    do {
                        System.out.println("Please choose a priority to be edited by inputting : 1 ~ 10");
                        System.out.println("1. Full name");
                        System.out.println("2. Birthday");
                        System.out.println("3. Gender");
                        System.out.println("4. Identity number");
                        System.out.println("5. Phone number");
                        System.out.println("6. Email");
                        System.out.println("7. Qualification");
                        System.out.println("8. Position");
                        System.out.println("9. Salary");
                        System.out.println("10. Exit");
                        int choice  = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Input new edited full name");
                                String editedFullName = sc.nextLine();
                                e.setFullName(editedFullName);
                                break;
                            case 2:
                                System.out.println("Input new edited birthday");
                                LocalDate editedBirthday = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                e.setBirthday(editedBirthday);
                                break;
                            case 3:
                                System.out.println("Input new edited gender");
                                String editedGender = sc.nextLine();
                                e.setGender(editedGender);
                                break;
                            case 4:
                                String editedIdentityNumber;
                                do {
                                    System.out.println("Input new edited identity number");
                                    editedIdentityNumber = sc.nextLine();
                                } while (isCoincidentIdentityNumber(editedIdentityNumber));
                                e.setIdentityNumber(editedIdentityNumber);
                                break;
                            case 5:
                                System.out.println("Input new edited phone number");
                                String editedPhoneNumber = sc.nextLine();
                                e.setPhoneNumber(editedPhoneNumber);
                                break;
                            case 6:
                                System.out.println("Input new edited email");
                                String editedEmail = sc.nextLine();
                                e.setEmail(editedEmail);
                                break;
                            case 7:
                                System.out.println("Input new edited qualification");
                                String editedQualification = sc.nextLine();
                                e.setQualification(editedQualification);
                                break;
                            case 8:
                                System.out.println("Input new edited position");
                                String editedPosition = sc.nextLine();
                                e.setPosition(editedPosition);
                                break;
                            case 9:
                                System.out.println("Input new edited salary");
                                double editedSalary = Double.parseDouble(sc.nextLine());
                                e.setSalary(editedSalary);
                                break;
                            case 10:
                                return;
                            default:
                                System.out.println("The option " + choice + " is invalid.");
                        }
                    } while (true);
                }
            }
        }
    }

    private boolean isIdUsed(String id) {
        for (Employee e : employeeList) {
            if (id.equals(e.getId())) {
                System.out.println("The id " + id + " has been used.");
                return true;
            }
        }
        return false ;
    }

    private boolean isGenderValid(String gender) {
        gender = gender.toUpperCase();
        for (Gender g : Gender.values()) {
            if (gender.equals(g.name())) {
                return true;
            }
        }
        System.out.println("Please input gender among these options: MALE, FEMALE, LGBT, UNKNOWN");
        return false ;
    }

    private boolean isCoincidentIdentityNumber(String identityNumber) {
        for (Employee e : employeeList) {
            if (identityNumber.equals(e.getIdentityNumber())) {
                System.out.println("The identity number " + identityNumber + " has been recorded for employee: " +  e);
                return true;
            }
        }
        return false ;
    }

    private boolean isQualificationValid(String qualification) {
        qualification = qualification.toUpperCase();
        for (EmployeeQualification eQ : EmployeeQualification.values()) {
            if (qualification.equals(eQ.name())) {
                return true;
            }
        }
        System.out.println("Please input qualification among these options: INTERMEDIATE, COLLEGE, UNDERGRADUATE," +
                " POSTGRADUATE");
        return false ;
    }

    private boolean isPositionValid(String position) {
        position = position.toUpperCase();
        for (EmployeePosition eP : EmployeePosition.values()) {
            if (position.equals(eP.name())) {
                return true;
            }
        }
        System.out.println("Please input qualification among these options: RECEPTIONIST, WAITER, SPECIALIST ," +
                " SUPERVISOR, MANAGER, DIRECTOR");
        return false ;
    }
}
