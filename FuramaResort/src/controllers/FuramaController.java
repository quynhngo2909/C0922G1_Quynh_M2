package controllers;


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
    private Scanner sc = new Scanner(System.in);
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private ICustomerService customerService = new CustomerServiceImpl();
    private IFacilityService facilityService = new FacilityServiceImpl();
    private IVillaService villaService = new VillaServiceImpl();
    private IRoomService roomService = new RoomServiceImpl();

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
            int mainOption = Integer.parseInt(sc.nextLine());
            switch (mainOption) {
                case 1:
                    int employeeOption;
                    do {
                        System.out.println("Employee Management Menu:");
                        System.out.println("1. Display list employees");
                        System.out.println("2. Add new employee");
                        System.out.println("3. Delete employee");
                        System.out.println("4. Edit employee");
                        System.out.println("5. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 5");
                        employeeOption = Integer.parseInt(sc.nextLine());
                        switch (employeeOption) {
                            case 1:
                                employeeService.displayList();
                                break;
                            case 2:
                                System.out.println("Input id for the new employee");
                                String id = sc.nextLine();

                                System.out.println("Input the new employee's full name");
                                String fullName = sc.nextLine();

                                String stringBirthday;
                                System.out.println("Input the new employee's birthday");
                                stringBirthday = Regex.validateInputtedVariable(Regex.BIRTHDAY, sc.nextLine(),
                                        "Birthday is in format dd/MM/yyyy", "birthday");
                                LocalDate birthday = Regex.validateUserAge(LocalDate.parse(stringBirthday,
                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                                String gender;
                                boolean isValidGender = false;
                                do {
                                    System.out.println("Input the new employee's gender");
                                    gender = sc.nextLine().toUpperCase();
                                    for (Gender g : Gender.values()) {
                                        if (gender.equals(g.name())) {
                                            isValidGender = true;
                                            break;
                                        }
                                    }
                                } while (!isValidGender);

                                System.out.println("Input the new employee's identityNumber");
                                String identityNumber = Regex.validateInputtedVariable(Regex.IDENTITY_NUMBER,
                                        sc.nextLine(),
                                        "Identity number is in format xxxxxxxxx, \"x\" is a number 0~9",
                                        "identity number");


                                System.out.println("Input the new employee's phone number");
                                String phoneNumber = Regex.validateInputtedVariable(Regex.PHONE_NUMBER,
                                        sc.nextLine(),
                                        "Phone number is in format xxxxxxxxxx, \"x\" is a number 0~9",
                                        "phone number");

                                System.out.println("Input the new employee's email");
                                String email = Regex.validateInputtedVariable(Regex.EMAIL,
                                        sc.nextLine(),
                                        "Email is in format *@*, \"*\" is any character",
                                        "mail");

                                System.out.println("Input the new employee's qualification");
                                String qualification;
                                boolean isValidQualification = false;
                                do {
                                    qualification = sc.nextLine().toUpperCase();
                                    boolean flag = false;
                                    for (EmployeeQualification eQ : EmployeeQualification.values()) {
                                        if (qualification.equals(eQ.name())) {
                                            isValidQualification = true;
                                            flag = true;
                                        }
                                    }
                                    if (!flag) {
                                        System.out.println("Input the new employee's qualification");
                                    }
                                } while (!isValidQualification);

                                System.out.println("Input the new employee's position");
                                String position;
                                boolean isValidPosition = false;
                                do {
                                    boolean flag = false;
                                    position = sc.nextLine().toUpperCase();
                                    for (EmployeePosition eP : EmployeePosition.values()) {
                                        if (position.equals(eP.name())) {
                                            isValidPosition = true;
                                            flag = true;
                                        }
                                    }
                                    if (!flag) {
                                        System.out.println("Input the new employee's position");
                                    }
                                } while (!isValidPosition);

                                System.out.println("Input the new employee's salary");
                                String stringSalary = Regex.validateInputtedVariable(Regex.SALARY,
                                        sc.nextLine(),
                                        "Salary must be a positive number",
                                        "salary");
                                double salary = Double.parseDouble(stringSalary);

                                Employee newEmployee = new Employee(id, fullName, birthday, gender, identityNumber,
                                        phoneNumber, email, qualification,
                                        position, salary);
                                employeeService.addNewEmployee(newEmployee);
                                break;
                            case 3:
                                System.out.println("Please input employee's id");
                                String deletedId = sc.nextLine();
                                employeeService.deleteEmployee(deletedId);
                                break;
                            case 4:
                                System.out.println("Please input employee's id for editing");
                                String editedId = sc.nextLine();
                                employeeService.editEmployee(editedId);
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
                        customerOption = Integer.parseInt(sc.nextLine());
                        switch (customerOption) {
                            case 1:
                                customerService.displayList();
                                break;
                            case 2:
                                System.out.println("Input id for the new customer");
                                String id = sc.nextLine();

                                System.out.println("Input the new customer's full name");
                                String fullName = sc.nextLine();

                                String stringBirthday;
                                System.out.println("Input the new customer's birthday");
                                stringBirthday = Regex.validateInputtedVariable(Regex.BIRTHDAY, sc.nextLine(),
                                        "Birthday is in format dd/MM/yyyy", "birthday");
                                LocalDate birthday = Regex.validateUserAge(LocalDate.parse(stringBirthday,
                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                                String gender;
                                boolean isValidGender = false;
                                do {
                                    System.out.println("Input the new customer's gender");
                                    gender = sc.nextLine().toUpperCase();
                                    for (Gender g : Gender.values()) {
                                        if (gender.equals(g.name())) {
                                            isValidGender = true;
                                            break;
                                        }
                                    }
                                } while (!isValidGender);

                                System.out.println("Input the new customer's identityNumber");
                                String identityNumber = Regex.validateInputtedVariable(Regex.IDENTITY_NUMBER,
                                        sc.nextLine(),
                                        "Identity number is in format xxxxxxxxx, \"x\" is a number 0~9",
                                        "identity number");


                                System.out.println("Input the new customer's phone number");
                                String phoneNumber = Regex.validateInputtedVariable(Regex.PHONE_NUMBER,
                                        sc.nextLine(),
                                        "Phone number is in format xxxxxxxxxx, \"x\" is a number 0~9",
                                        "phone number");

                                System.out.println("Input the new customer's email");
                                String email = Regex.validateInputtedVariable(Regex.EMAIL,
                                        sc.nextLine(),
                                        "Email is in format *@*, \"*\" is any character",
                                        "mail");


                                System.out.println("Please input customer type among these options: DIAMOND, PLATINUM, GOLD, SILVER, MEMBER");
                                String customerType = sc.nextLine().toUpperCase();
                                boolean isCustomerTypeValid = false;
                                do {
                                    for (CustomerType cT : CustomerType.values()) {
                                        if (customerType.equals(cT.name())) {
                                            isCustomerTypeValid = true;
                                            break;
                                        }
                                    }
                                } while (!isCustomerTypeValid);


                                System.out.println("Input the new customer's address");
                                String address = sc.nextLine();

                                Customer newCustomer = new Customer(id, fullName, birthday, gender, identityNumber, phoneNumber, email, customerType,
                                        address);

                                customerService.addNewCustomer(newCustomer);
                                break;
                            case 3:
                                System.out.println("Please input customer's id for editing");
                                String editedId = sc.nextLine();
                                customerService.editCustomer(editedId);
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
                    int facilityOption;
                    do {
                        System.out.println("Facility Management Menu:");
                        System.out.println("1. Display list facility");
                        System.out.println("2. Add new facility");
                        System.out.println("3. Display list facility maintenance");
                        System.out.println("4. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 4");
                        facilityOption = Integer.parseInt(sc.nextLine());
                        switch (facilityOption) {
                            case 1:
                                facilityService.displayList();
                                break;
                            case 2:
                                int choice;
                                do {
                                    System.out.println("Please choose a facility to be added");
                                    System.out.println("1. Add New Villa");
                                    System.out.println("2. Add New Room");
                                    System.out.println("3. Back to menu");
                                    choice = Integer.parseInt(sc.nextLine());
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Add a new villa");
                                            System.out.println("Please input villa  id");
                                            String id = Regex.validateInputtedVariable(Regex.FACILITY_VILLA_ID, sc.nextLine(),
                                                    " ID must be in format \\\"SVVL-YYYY\\\", " +
                                                            "with YYYY is numbers from 0-9",  " villa id");

                                            System.out.println("Please input  name");
                                            String facilityName =  Regex.validateInputtedVariable(Regex.FACILITY_NAME, sc.nextLine(),
                                                    "Name must begin with a capital character, and normal character onwards.", "villa name");

                                            System.out.println("Please input  usable area");
                                            String usableArea = Regex.validateInputtedVariable(Regex.USABLE_AREA, sc.nextLine(),
                                                    "Usable area must be a real number and bigger than 30",  " villa usable area");

                                            System.out.println("Please input rental fee");
                                            String rentalFee = Regex.validateInputtedVariable(Regex.RENTAL_FEE, sc.nextLine(),
                                                    "Rental fee must be a positive real number", " villa rental fee");

                                            System.out.println("Please input maximum capacity");
                                            String maxCap = Regex.validateInputtedVariable(Regex.MAX_CAP, sc.nextLine(),
                                                    "Maximum capacity must be bigger than 0 and smaller than 20.", "villa maximum capacity");

                                            System.out.println("Please input  rental type");
                                            String rentalType =  Regex.validateInputtedVariable(Regex.RENTAL_TYPE, sc.nextLine(),
                                                    "Rental type must begin with a capital character, and normal character onwards.", " villa rental type");

                                            System.out.println("Please input  room standard");
                                            String roomStandard = Regex.validateInputtedVariable(Regex.ROOM_STANDARD, sc.nextLine(),
                                                    "Room standard must begin with a capital character, and normal character onwards",  " room standard");

                                            System.out.println("Please input swimming pool area");
                                            String swimmingPoolArea = Regex.validateInputtedVariable(Regex.SWIMMING_POOL_AREA, sc.nextLine(),
                                                    "Swimming pool area must be a real number and bigger than 30", " swimming pool area");

                                            System.out.println("Please input floor number");
                                            String floorNumber =  Regex.validateInputtedVariable(Regex.FLOOR_NUMBER, sc.nextLine(),
                                                    "Floor number must be a positive real number",  " floor number");

                                            Facility newVilla = new Villa(id, facilityName, usableArea, rentalFee, maxCap, rentalType, roomStandard,
                                                    swimmingPoolArea, floorNumber);
                                            String facilityID = villaService.addNewVilla(newVilla);
                                            facilityService.addNewFacility(facilityID);
                                            break;
                                        case 2:
                                            System.out.println("Add a new Room");
                                            System.out.println("Please input room id");
                                            String roomId = Regex.validateInputtedVariable(Regex.FACILITY_ROOM_ID, sc.nextLine(),
                                                    "Room ID must be in format \\\"SVRO-YYYY\\\", with YYYY is numbers from 0-9",
                                                    "room id");


                                            System.out.println("Please input room name");
                                            String roomName = Regex.validateInputtedVariable(Regex.FACILITY_NAME, sc.nextLine(),
                                                    "Room name must begin with a capital character, and normal character onwards.",
                                                    " room name");

                                            System.out.println("Please input room usable area");
                                            String roomUsableArea = Regex.validateInputtedVariable(Regex.USABLE_AREA, sc.nextLine(),
                                                    "Usable area must be a real number and bigger than 30", " room usable area");

                                            System.out.println("Please input room rental fee");
                                            String roomRentalFee = Regex.validateInputtedVariable(Regex.RENTAL_FEE, sc.nextLine(),
                                                    "Rental fee must be a positive real number", " room rental fee");

                                            System.out.println("Please input room maximum capacity");
                                            String roomMaxCap = Regex.validateInputtedVariable(Regex.MAX_CAP, sc.nextLine(),
                                                    "Maximum capacity must be bigger than 0 and smaller than 20.",
                                                    " room maximum capacity");

                                            System.out.println("Please input room rental type");
                                            String roomRentalType = Regex.validateInputtedVariable(Regex.RENTAL_TYPE, sc.nextLine(),
                                                    "Rental type must begin with a capital character, and normal character onwards.",
                                                    "room rental type");

                                            System.out.println("Please input room free charged service");
                                            String freeChargedService = sc.nextLine();

                                            Facility newRoom = new Room(roomId, roomName, roomUsableArea, roomRentalFee,
                                                    roomMaxCap, roomRentalType, freeChargedService);

                                            String newRoomId = roomService.addNewRoom(newRoom);
                                            facilityService.addNewFacility(newRoomId);
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
                    int bookingOption;
                    do {
                        System.out.println("Booking Management Menu:");
                        System.out.println("1. Add new booking");
                        System.out.println("2. Display list booking");
                        System.out.println("3. Return to main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 3");
                        bookingOption = Integer.parseInt(sc.nextLine());
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
                    int promotionOption;
                    do {
                        System.out.println("Promotion Management Menu:");
                        System.out.println("1. Display list customers use service");
                        System.out.println("2. Display list customers get voucher");
                        System.out.println("3. Return main menu");
                        System.out.println("Please choose a function you need by entering one of these options: 1 ~ 3");
                        promotionOption = Integer.parseInt(sc.nextLine());
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
}
