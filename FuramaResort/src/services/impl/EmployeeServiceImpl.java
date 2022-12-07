package services.impl;

import libs.EmployeePosition;
import libs.EmployeeQualification;
import libs.Gender;
import models.Employee;
import services.IEmployeeService;
import services.IFileIO;
import utils.Regex;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService, IFileIO<Employee> {

    private static final String EMPLOYEE_FILE_PATH = "src\\data\\employee.csv";
    private Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            System.out.println(e.getValue().toString());
        }
    }

    @Override
    public void addNewEmployee() {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        String id;
        do {
            System.out.println("Input id for the new employee");
            id = sc.nextLine();
        } while (isIdUsed(id));

        String fullName;
        System.out.println("Input the new employee's full name");
        fullName = sc.nextLine();
        String stringBirthday;
        System.out.println("Input the new employee's birthday");
        stringBirthday = Regex.validateInputtedVariable(Regex.BIRTHDAY, sc.nextLine(),
                "Birthday is in format dd/MM/yyyy", "birthday");
        LocalDate birthday = Regex.validateUserAge(LocalDate.parse(stringBirthday,
                DateTimeFormatter.ofPattern("dd/MM/yyyy")));

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

        employeeMap.put(id, new Employee(id, fullName, birthday, gender, identityNumber, phoneNumber, email, qualification,
                position, salary));
        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            System.out.println(e.getKey() + "," + e.getValue().convertToCSVFormat());
        }
        writeFile(EMPLOYEE_FILE_PATH, employeeMap);
    }

    @Override
    public void deleteEmployee() {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        System.out.println("Please input employee's id");
        String deletedId = sc.nextLine();
        String tempDeletedID = null;
        for (String employeeID : employeeMap.keySet()) {
            if (deletedId.equals(employeeID)) {
                tempDeletedID = employeeID;
                break;
            }
        }
        if (tempDeletedID != null) {
            employeeMap.remove(tempDeletedID);
        }
        writeFile(EMPLOYEE_FILE_PATH, employeeMap);
    }

    @Override
    public void editEmployee() {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        System.out.println("Please input employee's id for editing");
        String editedId = sc.nextLine();
        if (!isIdUsed(editedId)) {
            System.out.println("The id " + editedId + " is not exit in employee list.");
        } else {
            for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
                if (editedId.equals(e.getKey())) {
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
                        int choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Input new edited full name");
                                String editedFullName = sc.nextLine();
                                e.getValue().setFullName(editedFullName);
                                break;
                            case 2:
                                System.out.println("Input new edited birthday");
                                LocalDate editedBirthday = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                e.getValue().setBirthday(editedBirthday);
                                break;
                            case 3:
                                System.out.println("Input new edited gender");
                                String editedGender = sc.nextLine();
                                e.getValue().setGender(editedGender);
                                break;
                            case 4:
                                String editedIdentityNumber;
                                do {
                                    System.out.println("Input new edited identity number");
                                    editedIdentityNumber = sc.nextLine();
                                } while (isCoincidentIdentityNumber(editedIdentityNumber));
                                e.getValue().setIdentityNumber(editedIdentityNumber);
                                break;
                            case 5:
                                System.out.println("Input new edited phone number");
                                String editedPhoneNumber = sc.nextLine();
                                e.getValue().setPhoneNumber(editedPhoneNumber);
                                break;
                            case 6:
                                System.out.println("Input new edited email");
                                String editedEmail = sc.nextLine();
                                e.getValue().setEmail(editedEmail);
                                break;
                            case 7:
                                System.out.println("Input new edited qualification");
                                String editedQualification = sc.nextLine();
                                e.getValue().setQualification(editedQualification);
                                break;
                            case 8:
                                System.out.println("Input new edited position");
                                String editedPosition = sc.nextLine();
                                e.getValue().setPosition(editedPosition);
                                break;
                            case 9:
                                System.out.println("Input new edited salary");
                                double editedSalary = Double.parseDouble(sc.nextLine());
                                e.getValue().setSalary(editedSalary);
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
        writeFile(EMPLOYEE_FILE_PATH, employeeMap);
    }

    private boolean isIdUsed(String id) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        for (String employeeID : employeeMap.keySet()) {
            if (id.equals(employeeID)) {
                System.out.println("The id " + id + " has been used.");
                return true;
            }
        }
        return false;
    }

    private boolean isGenderValid(String gender) {
        gender = gender.toUpperCase();
        for (Gender g : Gender.values()) {
            if (gender.equals(g.name())) {
                return true;
            }
        }
        System.out.println("Please input gender among these options: MALE, FEMALE, LGBT, UNKNOWN");
        return false;
    }

    private boolean isCoincidentIdentityNumber(String identityNumber) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            if (identityNumber.equals(e.getValue().getIdentityNumber())) {
                System.out.println("The identity number " + identityNumber + " has been recorded for employee: " + e.getValue());
                return true;
            }
        }
        return false;
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
        return false;
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
        return false;
    }

    private void validateFilePath(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Map<String, Employee> readFile(String filePath) {
        validateFilePath(filePath);
        Map<String, Employee> employeeMap = new LinkedHashMap<String, Employee>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                employeeMap.put(splitLine[0], new Employee(splitLine[1], splitLine[2],
                        LocalDate.parse(splitLine[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        splitLine[4], splitLine[5], splitLine[6], splitLine[7], splitLine[8], splitLine[9],
                        Double.parseDouble(splitLine[10])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeeMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Employee> employeeMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
                bw.write(e.getKey() + "," + e.getValue().convertToCSVFormat());
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
