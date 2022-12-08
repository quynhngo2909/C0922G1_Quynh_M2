package services.impl;

import models.Customer;
import services.ICustomerService;
import services.IFileIO;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerServiceImpl implements ICustomerService, IFileIO<Customer> {
    private static final String Customer_FILE_PATH = "src/data/customer.csv";

    @Override
    public void displayList() {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        for (Customer c : customerMap.values()) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void addNewCustomer(Customer customer) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        customerMap.put(customer.getId(), customer);
        writeFile(Customer_FILE_PATH, customerMap);
    }

    @Override
    public void editCustomer(Customer editedCustomer) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        String editedID = editedCustomer.getId();
        customerMap.get(editedID).setFullName(editedCustomer.getFullName());
        customerMap.get(editedID).setBirthday(editedCustomer.getBirthday());
        customerMap.get(editedID).setGender(editedCustomer.getGender());
        customerMap.get(editedID).setIdentityNumber(editedCustomer.getIdentityNumber());
        customerMap.get(editedID).setPhoneNumber(editedCustomer.getPhoneNumber());
        customerMap.get(editedID).setEmail(editedCustomer.getEmail());
        customerMap.get(editedID).setCustomerType(editedCustomer.getCustomerType());
        customerMap.get(editedID).setAddress(editedCustomer.getAddress());
        writeFile(Customer_FILE_PATH, customerMap);

    }

    public boolean isIdUsed(String id) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        for (String customerID : customerMap.keySet()) {
            if (id.equals(customerID)) {
                System.out.println("The id " + id + " has been used.");
                return true;
            }
        }
        return false;
    }


    public boolean isCoincidentIdentityNumber(String identityNumber) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        for (Customer c : customerMap.values()) {
            if (identityNumber.equals(c.getIdentityNumber())) {
                System.out.println("The identity number " + identityNumber + " has been recorded for employee: " + c);
                return true;
            }
        }
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
    public Map<String, Customer> readFile(String filePath) {
        Map<String, Customer> customerMap = new LinkedHashMap<String, Customer>();
        validateFilePath(filePath);
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                customerMap.put(splitLine[0], new Customer(splitLine[1], splitLine[2],
                        LocalDate.parse(splitLine[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")), splitLine[4],
                        splitLine[5], splitLine[6], splitLine[7], splitLine[8], splitLine[9]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Customer> customerMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Customer> e : customerMap.entrySet()) {
                bw.write(e.getKey() + "," + e.getValue().convertToCSVFormat());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
