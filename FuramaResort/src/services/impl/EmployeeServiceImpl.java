package services.impl;

import models.Employee;
import services.IEmployeeService;
import services.IFileIO;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService, IFileIO<Employee> {

    private static final String EMPLOYEE_FILE_PATH = "src\\data\\employee.csv";

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
            writeFile(EMPLOYEE_FILE_PATH, employeeMap);
        }
    }

    @Override
    public void editEmployee(Employee editedEmployee) {
        Map<String, Employee> employeeMap = readFile(EMPLOYEE_FILE_PATH);
        String editedID = editedEmployee.getId();
        employeeMap.get(editedID).setFullName(editedEmployee.getFullName());
        employeeMap.get(editedID).setBirthday(editedEmployee.getBirthday());
        employeeMap.get(editedID).setGender(editedEmployee.getGender());
        employeeMap.get(editedID).setIdentityNumber(editedEmployee.getIdentityNumber());
        employeeMap.get(editedID).setPhoneNumber(editedEmployee.getPhoneNumber());
        employeeMap.get(editedID).setQualification(editedEmployee.getQualification());
        employeeMap.get(editedID).setPosition(editedEmployee.getPosition());
        employeeMap.get(editedID).setSalary(editedEmployee.getSalary());
        writeFile(EMPLOYEE_FILE_PATH, employeeMap);
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
