package controllers;

import services.ICustomerService;
import services.IEmployeeService;
import services.IFacilityService;
import services.impl.CustomerServiceImpl;
import services.impl.EmployeeServiceImpl;
import services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private Scanner sc = new Scanner(System.in);
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private ICustomerService customerService = new CustomerServiceImpl();
    private IFacilityService facilityService = new FacilityServiceImpl();

    public void displayMainMenu() {
        do {
            System.out.println("views.Main Menu:");
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
                                employeeService.addNewEmployee();
                                break;
                            case 3:
                                employeeService.deleteEmployee();
                                break;
                            case 4:
                                employeeService.editEmployee();
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
                                customerService.addNewCustomer();
                                break;
                            case 3:
                                customerService.editCustomer();
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
                                facilityService.addNewFacility();
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
