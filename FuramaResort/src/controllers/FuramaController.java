package controllers;


import exception.InvalidAgeException;
import exception.NotFoundException;
import exception.NumberFormatException;
import libs.CustomerType;
import libs.EmployeePosition;
import libs.EmployeeQualification;
import libs.Gender;
import models.*;
import services.*;
import services.impl.*;
import utils.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FuramaController {
    private final Scanner sc = new Scanner(System.in);
    private final IEmployeeService employeeService = new EmployeeServiceImpl();
    private final ICustomerService customerService = new CustomerServiceImpl();
    private final IFacilityService facilityService = new FacilityServiceImpl();
    private final IVillaService villaService = new VillaServiceImpl();
    private final IRoomService roomService = new RoomServiceImpl();

    public void displayMainMenu() {
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Please choose a function you need by entering one of these options: 1 ~ 6");
            String stringMainOption;
            int mainOption;
            do {
                try {
                    stringMainOption = sc.nextLine();
                    validateInputOption(stringMainOption);
                    mainOption = Integer.parseInt(stringMainOption);
                    break;
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            } while (true);

            switch (mainOption) {
                case 1:
                    String stringEmployeeOption;
                    int employeeOption;
                    do {
                        System.out.println("Employee Management Menu:");
                        System.out.println("1. Display list employees");
                        System.out.println("2. Add new employee");
                        System.out.println("3. Delete employee");
                        System.out.println("4. Edit employee");
                        System.out.println("5. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 5");

                        do {
                            try {
                                stringEmployeeOption = sc.nextLine();
                                validateInputOption(stringEmployeeOption);
                                employeeOption = Integer.parseInt(stringEmployeeOption);
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println(e.getMessage());
                            }
                        } while (true);

                        switch (employeeOption) {
                            case 1:
                                employeeService.displayList();
                                break;
                            case 2:
                                Employee newEmployee = employeeControllerAddNew();
                                employeeService.addNewEmployee(newEmployee);
                                break;
                            case 3:
                                System.out.println("Please input employee's id");
                                employeeControllerDelete(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Please input employee's id for editing");
                                employeeControllerEdit(sc.nextLine());
                                break;
                            case 5:
                                System.out.println("Return to main menu");
                                break;
                            default:
                                System.out.println("The option " + employeeOption + " is invalid.");
                        }
                    } while (employeeOption != 5);
                    break;
                case 2:
                    int customerOption;
                    do {
                        System.out.println("Customer Management Menu:");
                        System.out.println("1. Display list customers");
                        System.out.println("2. Add new customer");
                        System.out.println("3. Edit customer");
                        System.out.println("4. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 4");
                        String stringCustomerOption;
                        do {
                            try {
                                stringCustomerOption = sc.nextLine();
                                validateInputOption(stringCustomerOption);
                                customerOption = Integer.parseInt(stringCustomerOption);
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println(e.getMessage());
                            }
                        } while (true);

                        switch (customerOption) {
                            case 1:
                                customerService.displayList();
                                break;
                            case 2:
                                Customer newCustomer = customerControllerAddNew();
                                customerService.addNewCustomer(newCustomer);
                                break;
                            case 3:
                                System.out.println("Please input customer's id for editing");
                                customerControllerEdit(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Return to main menu");
                                break;
                            default:
                                System.out.println("The option " + customerOption + " is invalid.");
                        }
                    } while (customerOption != 4);
                    break;
                case 3:
                    String stringFacilityOption;
                    int facilityOption;
                    do {
                        System.out.println("Facility Management Menu:");
                        System.out.println("1. Display list facility");
                        System.out.println("2. Add new facility");
                        System.out.println("3. Display list facility maintenance");
                        System.out.println("4. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 4");
                        do {
                            try {
                                stringFacilityOption = sc.nextLine();
                                validateInputOption(stringFacilityOption);
                                facilityOption = Integer.parseInt(stringFacilityOption);
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println(e.getMessage());
                            }
                        } while (true);

                        switch (facilityOption) {
                            case 1:
                                facilityService.displayList();
                                break;
                            case 2:
                                String stringChoice;
                                int choice;
                                do {
                                    System.out.println("Please choose a facility to be added");
                                    System.out.println("1. Add New Villa");
                                    System.out.println("2. Add New Room");
                                    System.out.println("3. Back to menu");
                                    do {
                                        try {
                                            stringChoice = sc.nextLine();
                                            validateInputOption(stringChoice);
                                            choice = Integer.parseInt(stringChoice);
                                            break;
                                        } catch (NumberFormatException e) {
                                            System.err.println(e.getMessage());
                                        }
                                    } while (true);

                                    switch (choice) {
                                        case 1:
                                            facilityControllerAddNewVilla();
                                            break;
                                        case 2:
                                            facilityControllerAddNewRoom();
                                            break;
                                        case 3:
                                            System.out.println("Back to menu");
                                            break;
                                        default:
                                            System.out.println("The option " + choice + " is invalid.");
                                    }
                                } while (choice != 3);
                                break;
                            case 3:
                                facilityService.displayListFacilityMaintenance();
                                break;
                            case 4:
                                System.out.println("Return to main menu");
                                break;
                            default:
                                System.out.println("The option " + facilityOption + " is invalid.");
                        }
                    } while (facilityOption != 4);
                    break;
                case 4:
                    String stringBookingOption;
                    int bookingOption;
                    do {
                        System.out.println("Booking Management Menu:");
                        System.out.println("1. Add new booking");
                        System.out.println("2. Display list booking");
                        System.out.println("3. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 3");
                        do {
                            try {
                                stringBookingOption = sc.nextLine();
                                validateInputOption(stringBookingOption);
                                bookingOption = Integer.parseInt(stringBookingOption);
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println(e.getMessage());
                            }
                        } while (true);
                        switch (bookingOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                System.out.println("Return to main menu");
                                break;
                            default:
                                System.out.println("The option " + bookingOption + " is invalid.");
                        }
                    } while (bookingOption != 3);
                    break;
                case 5:
                    String stringPromotionOption;
                    int promotionOption;
                    do {
                        System.out.println("Promotion Management Menu:");
                        System.out.println("1. Display list customers use service");
                        System.out.println("2. Display list customers get voucher");
                        System.out.println("3. Return main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 3");
                        do {
                            try {
                                stringPromotionOption = sc.nextLine();
                                validateInputOption(stringPromotionOption);
                                promotionOption = Integer.parseInt(stringPromotionOption);
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println(e.getMessage());
                            }
                        } while (true);

                        switch (promotionOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                System.out.println("Return to main menu");
                                break;
                            default:
                                System.out.println("The option " + promotionOption + " is invalid.");
                        }
                    } while (promotionOption != 3);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("The option " + mainOption + " is invalid.");
            }
        } while (true);
    }

    private String getValidVariable(String regex, String inputtedVariable, String variableRequirement) {
        String validVariable = inputtedVariable;
        while (!Regex.isValidateInputtedVariable(regex, validVariable)) {
            System.out.println(variableRequirement + ". Please input again:");
            validVariable = sc.nextLine();
        }

        return validVariable;
    }

    private String getValidGender(String gender) {
        boolean isValidGender = false;
        String validGender = gender;
        do {
            validGender = validGender.toUpperCase();
            for (Gender g : Gender.values()) {
                if (validGender.equals(g.name())) {
                    isValidGender = true;
                    break;
                }
            }
            if (!isValidGender) {
                System.out.println("Please input again one of these option: Male, Female, LGBT, Unknown");
                validGender = sc.nextLine();
            }
        } while (!isValidGender);

        return validGender;
    }

    private String getValidQualification(String qualification) {
        String validQualification = qualification;
        do {
            validQualification = validQualification.toUpperCase();
            for (EmployeeQualification eQ : EmployeeQualification.values()) {
                if (validQualification.equals(eQ.name())) {
                    return validQualification;
                }
            }
            System.out.println(" INTERMEDIATE, COLLEGE, UNDERGRADUATE, POSTGRADUATE");
            validQualification = sc.nextLine();
        } while (true);
    }

    private String getValidPosition(String position) {
        String validPosition = position;
        do {
            validPosition = validPosition.toUpperCase();
            for (EmployeePosition eP : EmployeePosition.values()) {
                if (validPosition.equals(eP.name())) {
                    return validPosition;
                }
            }
            System.out.println("Please input again one of these option:  RECEPTIONIST, WAITER, SPECIALIST ," +
                    " SUPERVISOR, MANAGER, DIRECTOR");
            validPosition = sc.nextLine();
        } while (true);
    }

    private String getValidCustomerType(String customerType) {
        String validCustomerType = customerType;
        do {
            validCustomerType = validCustomerType.toUpperCase();
            for (CustomerType cT : CustomerType.values()) {
                if (validCustomerType.equals(cT.name())) {
                    return validCustomerType;
                }
            }
            System.out.println("Please input again one of these option:" +
                    "DIAMOND, PLATINUM, GOLD, SILVER, MEMBER");
            validCustomerType = sc.nextLine();
        } while (true);
    }

    private Employee employeeControllerAddNew() {
        String id;
        do {
            System.out.println("Input id for employee");
            id = sc.nextLine();
        } while (employeeService.isIdUsed(id));

        return createTempEmployeeWithProvidedID(id);
    }

    private void employeeControllerDelete(String id) {
        if (!employeeService.isIdUsed(id)) {
            try {
                throw new NotFoundException("The employee is not exist.");
            } catch (NotFoundException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("The employee is exist. Proceed next steps");
            employeeService.deleteEmployee(id);
        }
    }

    private void employeeControllerEdit(String id) {
        if (!employeeService.isIdUsed(id)) {
            try {
                throw new NotFoundException("The employee is not exist.");
            } catch (NotFoundException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("The employee is exist. Proceed next steps");
            employeeService.editEmployee(createTempEmployeeWithProvidedID(id));
        }
    }

    private Employee createTempEmployeeWithProvidedID(String id) {
        System.out.println("Input employee's full name");
        String fullName = sc.nextLine();

        System.out.println("Input employee's birthday");
        String stringBirthday = sc.nextLine();
        LocalDate birthday;
        do {
            stringBirthday = getValidVariable(Regex.BIRTHDAY, stringBirthday,
                    "Birthday is in format dd/MM/yyyy");
            birthday = LocalDate.parse(stringBirthday,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            try {
                Regex.isValidateAge(birthday);
                break;
            } catch (InvalidAgeException e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        System.out.println("Please input employee's gender");
        String gender = sc.nextLine();
        gender = getValidGender(gender);

        String identityNumber;
        do {
            System.out.println("Input employee's identityNumber");
            identityNumber = getValidVariable(Regex.IDENTITY_NUMBER, sc.nextLine(),
                    "Identity number is in format xxxxxxxxx," +
                            " \"x\" is a number 0~9");
        } while (employeeService.isCoincidentIdentityNumber(identityNumber));

        System.out.println("Input employee's phone number");
        String phoneNumber = sc.nextLine();
        phoneNumber = getValidVariable(Regex.PHONE_NUMBER, phoneNumber,
                "Phone number is in format xxxxxxxxxx, \"x\" is a number 0~9");

        System.out.println("Input employee's email");
        String email = sc.nextLine();
        email = getValidVariable(Regex.EMAIL, email,
                "Email is in format *@*, \"*\" is any character");


        System.out.println("Input employee's qualification");
        String qualification = sc.nextLine();
        qualification = getValidQualification(qualification);

        System.out.println("Input employee's position");
        String position = sc.nextLine();
        position = getValidPosition(position);

        System.out.println("Input employee's salary");
        String stringSalary = sc.nextLine();
        stringSalary = getValidVariable(Regex.SALARY, stringSalary,
                "Salary must be a positive number");
        double salary = Double.parseDouble(stringSalary);

        return new Employee(id, fullName, birthday, gender, identityNumber,
                phoneNumber, email, qualification,
                position, salary);
    }

    private Customer createTempCustomerWithProvidedID(String id) {
        System.out.println("Input customer's full name");
        String fullName = sc.nextLine();

        System.out.println("Input customer's birthday");
        String stringBirthday;
        LocalDate birthday;
        do {
            stringBirthday = getValidVariable(Regex.BIRTHDAY, sc.nextLine(),
                    "Birthday is in format dd/MM/yyyy");
            birthday = LocalDate.parse(stringBirthday,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            try {
                Regex.isValidateAge(birthday);
                break;
            } catch (InvalidAgeException e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        System.out.println("Please input customer's gender");
        String gender = sc.nextLine();
        gender = getValidGender(gender);

        String identityNumber;
        do {
            System.out.println("Input customer's identityNumber");
            identityNumber = getValidVariable(Regex.IDENTITY_NUMBER, sc.nextLine(),
                    "Identity number is in format xxxxxxxxx," +
                            " \"x\" is a number 0~9");
        } while (employeeService.isCoincidentIdentityNumber(identityNumber));

        System.out.println("Input customer's phone number");
        String phoneNumber = sc.nextLine();
        phoneNumber = getValidVariable(Regex.PHONE_NUMBER, phoneNumber,
                "Phone number is in format xxxxxxxxxx, \"x\" is a number 0~9");

        System.out.println("Input customer's email");
        String email = sc.nextLine();
        email = getValidVariable(Regex.EMAIL, email,
                "Email is in format *@*, \"*\" is any character");


        System.out.println("Input customer type");
        String customerType = sc.nextLine();
        customerType = getValidCustomerType(customerType);


        System.out.println("Input customer's address");
        String address = sc.nextLine();

        return new Customer(id, fullName, birthday, gender, identityNumber,
                phoneNumber, email, customerType, address);

    }

    private Customer customerControllerAddNew() {
        String id;
        do {
            System.out.println("Input id for customer");
            id = sc.nextLine();
        } while (customerService.isIdUsed(id));

        return createTempCustomerWithProvidedID(id);
    }

    private void customerControllerEdit(String id) {
        if (!customerService.isIdUsed(id)) {
            try {
                throw new NotFoundException("The customer is not exist.");
            } catch (NotFoundException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("The customer is exist. Proceed next steps");
            customerService.editCustomer(createTempCustomerWithProvidedID(id));
        }
    }

    private void facilityControllerAddNewVilla() {
        System.out.println("Add a new villa");
        String id;
        do {
            System.out.println("Please input villa  id");
            id = Regex.isValidateInputtedVariable(Regex.FACILITY_VILLA_ID, sc.nextLine(),
                    " ID must be in format \\\"SVVL-YYYY\\\", " +
                            "with YYYY is numbers from 0-9", " villa id");
        } while (villaService.isUsedID(id));

        System.out.println("Please input  name");
        String facilityName = Regex.isValidateInputtedVariable(Regex.FACILITY_NAME, sc.nextLine(),
                "Name must begin with a capital character, and normal character onwards.", "villa name");

        System.out.println("Please input  usable area");
        String usableArea = Regex.isValidateInputtedVariable(Regex.USABLE_AREA, sc.nextLine(),
                "Usable area must be a real number and bigger than 30", " villa usable area");

        System.out.println("Please input rental fee");
        String rentalFee = Regex.isValidateInputtedVariable(Regex.RENTAL_FEE, sc.nextLine(),
                "Rental fee must be a positive real number", " villa rental fee");

        System.out.println("Please input maximum capacity");
        String maxCap = Regex.isValidateInputtedVariable(Regex.MAX_CAP, sc.nextLine(),
                "Maximum capacity must be bigger than 0 and smaller than 20.", "villa maximum capacity");

        System.out.println("Please input  rental type");
        String rentalType = Regex.isValidateInputtedVariable(Regex.RENTAL_TYPE, sc.nextLine(),
                "Rental type must begin with a capital character, and normal character onwards.", " villa rental type");

        System.out.println("Please input  room standard");
        String roomStandard = Regex.isValidateInputtedVariable(Regex.ROOM_STANDARD, sc.nextLine(),
                "Room standard must begin with a capital character, and normal character onwards", " room standard");

        System.out.println("Please input swimming pool area");
        String swimmingPoolArea = Regex.isValidateInputtedVariable(Regex.SWIMMING_POOL_AREA, sc.nextLine(),
                "Swimming pool area must be a real number and bigger than 30", " swimming pool area");

        System.out.println("Please input floor number");
        String floorNumber = Regex.isValidateInputtedVariable(Regex.FLOOR_NUMBER, sc.nextLine(),
                "Floor number must be a positive real number", " floor number");

        Facility newVilla = new Villa(id, facilityName, usableArea, rentalFee, maxCap, rentalType, roomStandard,
                swimmingPoolArea, floorNumber);
        String facilityID = villaService.addNewVilla(newVilla);
        facilityService.addNewFacility(facilityID);
    }

    private void facilityControllerAddNewRoom() {
        System.out.println("Add a new Room");
        String roomId;
        do {
            System.out.println("Please input room id");
            roomId = Regex.isValidateInputtedVariable(Regex.FACILITY_ROOM_ID, sc.nextLine(),
                    "Room ID must be in format \\\"SVRO-YYYY\\\", with YYYY is numbers from 0-9",
                    "room id");
        } while (roomService.isUsedID(roomId));

        System.out.println("Please input room name");
        String roomName = Regex.isValidateInputtedVariable(Regex.FACILITY_NAME, sc.nextLine(),
                "Room name must begin with a capital character, and normal character onwards.",
                " room name");

        System.out.println("Please input room usable area");
        String roomUsableArea = Regex.isValidateInputtedVariable(Regex.USABLE_AREA, sc.nextLine(),
                "Usable area must be a real number and bigger than 30", " room usable area");

        System.out.println("Please input room rental fee");
        String roomRentalFee = Regex.isValidateInputtedVariable(Regex.RENTAL_FEE, sc.nextLine(),
                "Rental fee must be a positive real number", " room rental fee");

        System.out.println("Please input room maximum capacity");
        String roomMaxCap = Regex.isValidateInputtedVariable(Regex.MAX_CAP, sc.nextLine(),
                "Maximum capacity must be bigger than 0 and smaller than 20.",
                " room maximum capacity");

        System.out.println("Please input room rental type");
        String roomRentalType = Regex.isValidateInputtedVariable(Regex.RENTAL_TYPE, sc.nextLine(),
                "Rental type must begin with a capital character, and normal character onwards.",
                "room rental type");

        System.out.println("Please input room free charged service");
        String freeChargedService = sc.nextLine();

        Facility newRoom = new Room(roomId, roomName, roomUsableArea, roomRentalFee,
                roomMaxCap, roomRentalType, freeChargedService);

        String newRoomId = roomService.addNewRoom(newRoom);
        facilityService.addNewFacility(newRoomId);
    }

    private void validateInputOption(String string) throws NumberFormatException {
        for (Character c : string.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException("Invalid. Please input again");
            }
        }
    }
}

