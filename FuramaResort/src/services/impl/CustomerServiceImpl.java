package services.impl;


import libs.CustomerType;
import libs.Gender;
import models.Customer;
import services.ICustomerService;
import utils.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerServiceImpl implements ICustomerService {
    static List<Customer> customerList = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    @Override
    public void displayList() {
        for (Customer c : customerList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void addNewCustomer() {
        String id;
        do {
            System.out.println("Input id for the new customer");
            id = sc.nextLine();
        } while (isIdUsed(id));

        String fullName;
        System.out.println("Input the new customer's full name");
        fullName = sc.nextLine();
        LocalDate birthday;
        System.out.println("Input the new customer's birthday");
        birthday = Regex.validateUserAge(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        String gender;
        do {
            System.out.println("Input the new customer's gender");
            gender = sc.nextLine();
        } while (!isGenderValid(gender));

        String identityNumber;
        do {
            System.out.println("Input the new customer's identityNumber");
            identityNumber = sc.nextLine();
        } while (isCoincidentIdentityNumber(identityNumber));

        String phoneNumber;
        System.out.println("Input the new customer's phone number");
        phoneNumber = sc.nextLine();
        String email;
        System.out.println("Input the new customer's email");
        email = sc.nextLine();

        String customerType;
        do {
            System.out.println("Input the new customer's customer type");
            customerType = sc.nextLine();
        } while (!isCustomerTypeValid(customerType));

        String address;
        System.out.println("Input the new customer's address");
        address = sc.nextLine();

        customerList.add(new Customer(id, fullName, birthday, gender, identityNumber, phoneNumber, email, customerType,
                address));
    }

    @Override
    public void editCustomer() {
        System.out.println("Please input customer's id for editing");
        String editedId = sc.nextLine();
        if (!isIdUsed(editedId)) {
            System.out.println("The id " + editedId + " is not exit in customer list.");
        } else {
            for (Customer c : customerList) {
                if (editedId.equals(c.getId())) {
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
                        int choice  = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Input new edited full name");
                                String editedFullName = sc.nextLine();
                                c.setFullName(editedFullName);
                                break;
                            case 2:
                                System.out.println("Input new edited birthday");
                                LocalDate editedBirthday = LocalDate.parse(sc.nextLine(),
                                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                c.setBirthday(editedBirthday);
                                break;
                            case 3:
                                System.out.println("Input new edited gender");
                                String editedGender = sc.nextLine();
                                c.setGender(editedGender);
                                break;
                            case 4:
                                String editedIdentityNumber;
                                do {
                                    System.out.println("Input new edited identity number");
                                    editedIdentityNumber = sc.nextLine();
                                } while (isCoincidentIdentityNumber(editedIdentityNumber));
                                c.setIdentityNumber(editedIdentityNumber);
                                break;
                            case 5:
                                System.out.println("Input new edited phone number");
                                String editedPhoneNumber = sc.nextLine();
                                c.setPhoneNumber(editedPhoneNumber);
                                break;
                            case 6:
                                System.out.println("Input new edited email");
                                String editedEmail = sc.nextLine();
                                c.setEmail(editedEmail);
                                break;
                            case 7:
                                System.out.println("Input new edited customer type");
                                String editedCustomerType = sc.nextLine();
                                c.setCustomerType(editedCustomerType);
                                break;
                            case 8:
                                System.out.println("Input new edited address");
                                String editedAddress = sc.nextLine();
                                c.setAddress(editedAddress);
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
    }
    private boolean isIdUsed(String id) {
        for (Customer c : customerList) {
            if (id.equals(c.getId())) {
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
        for (Customer c : customerList) {
            if (identityNumber.equals(c.getIdentityNumber())) {
                System.out.println("The identity number " + identityNumber + " has been recorded for employee: " + c);
                return true;
            }
        }
        return false ;
    }

    private boolean isCustomerTypeValid(String customerType) {
        customerType = customerType.toUpperCase();
        for (CustomerType cT : CustomerType.values()) {
            if (customerType.equals(cT.name())) {
                return true;
            }
        }
        System.out.println("Please input customer type among these options: DIAMOND, PLATINUM, GOLD, SILVER, MEMBER");
        return false ;
    }
}
