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

    private Scanner sc = new Scanner(System.in);

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

        String tempId = customer.getId();
        while (isIdUsed(tempId)) {
            System.out.println("The id " + tempId + " has been used. Please input id for the new customer");
            tempId = sc.nextLine();
        }

        customer.setId(tempId);

        String tempIdentityNumber = customer.getIdentityNumber();
        while (isCoincidentIdentityNumber(tempIdentityNumber)) {
            System.out.println("The identity number " + tempIdentityNumber + " has been used." +
                    "Input identity number for the new customer");
            tempIdentityNumber = sc.nextLine();
        }

        customer.setIdentityNumber(tempIdentityNumber);


        customerMap.put(customer.getId(), customer);
        writeFile(Customer_FILE_PATH, customerMap);
    }

    @Override
    public void editCustomer(String editedId) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        String tempEditedID = editedId;
        while (!isIdUsed(tempEditedID)) {
            System.out.println( "Please input new Id");
            tempEditedID = sc.nextLine();
        }

        for (String customerID : customerMap.keySet()) {
            if (tempEditedID.equals(customerID)) {
                do {
                    System.out.println("Please choose a option to be edited by inputting : 1 ~ 10");
                    System.out.println("1. Full name");
                    System.out.println("2. Birthday");
                    System.out.println("3. Gender");
                    System.out.println("4. Identity number");
                    System.out.println("5. Phone number");
                    System.out.println("6. Email");
                    System.out.println("7. Customer type");
                    System.out.println("8. Address");
                    System.out.println("9. Exit");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Input new edited full name");
                            String editedFullName = sc.nextLine();
                            customerMap.get(customerID).setFullName(editedFullName);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 2:
                            System.out.println("Input new edited birthday");
                            LocalDate editedBirthday = LocalDate.parse(sc.nextLine(),
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            customerMap.get(customerID).setBirthday(editedBirthday);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 3:
                            System.out.println("Input new edited gender");
                            String editedGender = sc.nextLine();
                            customerMap.get(customerID).setGender(editedGender);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 4:
                            String editedIdentityNumber;
                            do {
                                System.out.println("Input new edited identity number");
                                editedIdentityNumber = sc.nextLine();
                            } while (isCoincidentIdentityNumber(editedIdentityNumber));
                            customerMap.get(customerID).setIdentityNumber(editedIdentityNumber);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 5:
                            System.out.println("Input new edited phone number");
                            String editedPhoneNumber = sc.nextLine();
                            customerMap.get(customerID).setPhoneNumber(editedPhoneNumber);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 6:
                            System.out.println("Input new edited email");
                            String editedEmail = sc.nextLine();
                            customerMap.get(customerID).setEmail(editedEmail);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 7:
                            System.out.println("Input new edited customer type");
                            String editedCustomerType = sc.nextLine();
                            customerMap.get(customerID).setCustomerType(editedCustomerType);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 8:
                            System.out.println("Input new edited address");
                            String editedAddress = sc.nextLine();
                            customerMap.get(customerID).setAddress(editedAddress);
                            writeFile(Customer_FILE_PATH, customerMap);
                            break;
                        case 9:
                            return;
                        default:
                            System.out.println("The option " + choice + " is invalid.");
                    }
                } while (true);
            }
        }
    }
    private boolean isIdUsed(String id) {
        Map<String, Customer> customerMap = readFile(Customer_FILE_PATH);
        for (String customerID : customerMap.keySet()) {
            if (id.equals(customerID)) {
                System.out.println("The id " + id + " has been used.");
                return true;
            }
        }
        return false;
    }


    private boolean isCoincidentIdentityNumber(String identityNumber) {
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
