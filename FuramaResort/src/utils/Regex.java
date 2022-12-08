package utils;

import exception.InvalidAgeException;

import java.time.LocalDate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {

    public static final String FACILITY_VILLA_ID = "^(SVVL)-\\d{4}$";
    public static final String FACILITY_ROOM_ID = "^(SVRO)-\\d{4}$";
    public static final String FACILITY_NAME = "^[A-Z][a-z0-9]*$";
    public static final String USABLE_AREA = "^3[1-9]$|^[4-9]\\d$|^[1-9]\\d{2,}$";
    public static final String SWIMMING_POOL_AREA = "^3[1-9]$|^[4-9]\\d$|^[1-9]\\d{2,}$";
    public static final String RENTAL_FEE = "^[1-9]\\d*$|^[1-9]$";
    public static final String MAX_CAP = "^^[1-9]$|^1[0-9]$";
    public static final String FLOOR_NUMBER = "^[1-9]\\d*$|^[1-9]$\"";
    public static final String RENTAL_TYPE = "^[A-Z][a-z0-9]*$";
    public static final String ROOM_STANDARD = "^[A-Z][a-z0-9]*$";

    public static final String BIRTHDAY = "^(0[1-9]|[1]\\d|[2]\\d|[3][0-1])/([0][1-9]|[1][0-2])/\\d{4}$";
    public static final String IDENTITY_NUMBER = "^\\d{9}$";
    public static final String PHONE_NUMBER = "^\\d{10}$";
    public static final String EMAIL = "^\\w{1,}@(\\w+[.]\\w+){1,}$";
    public static final String SALARY = "^\\d{1,}$";


    private static final Scanner sc = new Scanner(System.in);

    public static String isValidateInputtedVariable(String regex, String inputString, String regexRequirement, String checkedObject) {
        String stringOutput = inputString;
        boolean isValidInputString = false;
        do {
            if (Pattern.matches(regex, stringOutput)) {
                isValidInputString = true;
            } else {
                System.out.println(regexRequirement);
                System.out.println(" Please input new " + checkedObject);
                stringOutput = sc.nextLine();
            }

        } while (!isValidInputString);

        return stringOutput;
    }


    public static boolean isValidateInputtedVariable(String regex, String inputString) {
        return Pattern.matches(regex, inputString);
    }

    public static void isValidateAge(LocalDate birthday) throws InvalidAgeException {
        int age = LocalDate.now().getYear() - birthday.getYear();
        if (age < 18 || age > 100) {
            throw new InvalidAgeException("Age must be between 18 ~ 100");
        } else {
            System.out.println("Age is valid.");
        }
    }
}
