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
    public void addNewEmployee(Employee o) {

        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        String tempId = o.getId();
        while (isIdUsed(tempId)) {
            System.out.println("The id " + tempId + " has been used. Please input id for the new employee");
            tempId = sc.nextLine();
        }

        o.setId(tempId);

        String tempIdentityNumber = o.getIdentityNumber();
        while (isCoincidentIdentityNumber(tempIdentityNumber)) {
            System.out.println("The identity number " + tempIdentityNumber + " has been used.Input identity number for the new employee");
            tempIdentityNumber = sc.nextLine();
        }

        o.setIdentityNumber(tempIdentityNumber);

        employeeMap.put(o.getId(), o);
        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue().toString());
        }
        writeFile(EMPLOYEE_FILE_PATH, employeeMap);
    }

    @Override
    public void deleteEmployee(String deletedID) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        String tempDeletedID = null;
        for (String employeeID : employeeMap.keySet()) {
            if (deletedID.equals(employeeID)) {
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
    public void editEmployee(String editedID) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        String tempEditedID = editedID;
        while (!isIdUsed(tempEditedID)) {
            System.out.println( "Please input new Id");
            tempEditedID = sc.nextLine();
        }

        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            if (tempEditedID.equals(e.getKey())) {
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
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 2:
                            System.out.println("Input new edited birthday");
                            LocalDate editedBirthday = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            e.getValue().setBirthday(editedBirthday);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 3:
                            System.out.println("Input new edited gender");
                            String editedGender = sc.nextLine();
                            e.getValue().setGender(editedGender);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 4:
                            String editedIdentityNumber;
                            do {
                                System.out.println("Input new edited identity number");
                                editedIdentityNumber = sc.nextLine();
                            } while (isCoincidentIdentityNumber(editedIdentityNumber));
                            e.getValue().setIdentityNumber(editedIdentityNumber);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 5:
                            System.out.println("Input new edited phone number");
                            String editedPhoneNumber = sc.nextLine();
                            e.getValue().setPhoneNumber(editedPhoneNumber);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 6:
                            System.out.println("Input new edited email");
                            String editedEmail = sc.nextLine();
                            e.getValue().setEmail(editedEmail);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 7:
                            System.out.println("Input new edited qualification");
                            String editedQualification = sc.nextLine();
                            e.getValue().setQualification(editedQualification);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 8:
                            System.out.println("Input new edited position");
                            String editedPosition = sc.nextLine();
                            e.getValue().setPosition(editedPosition);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
                            break;
                        case 9:
                            System.out.println("Input new edited salary");
                            double editedSalary = Double.parseDouble(sc.nextLine());
                            e.getValue().setSalary(editedSalary);
                            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
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

    public boolean isIdUsed(String id) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        for (String employeeID : employeeMap.keySet()) {
            if (id.equals(employeeID)) {
                System.out.println("The id " + id + " has been used.");
                return true;
            }
        }
        return false;
    }

    public boolean isCoincidentIdentityNumber(String identityNumber) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        for (Map.Entry<String, Employee> e : employeeMap.entrySet()) {
            if (identityNumber.equals(e.getValue().getIdentityNumber())) {
                System.out.println("The identity number " + identityNumber + " has been recorded for employee: " + e.getValue());
                return true;
            }
        }
        return false;
    }


    public void validateFilePath(String filePath) {
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
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
