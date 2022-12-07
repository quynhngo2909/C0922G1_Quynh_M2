package utils;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
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

    public static final String BIRTHDAY = "^\\d{2}/\\d{2}/\\d{4}$";

    private static final Scanner sc = new Scanner(System.in);

    public static String validateInputtedVariable(String regex, String inputString, String regexRequirement, String checkedObject) {
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

    public  static LocalDate validateUserAge(LocalDate birthday) {
        LocalDate outputBirthday = birthday;
        LocalDate today = LocalDate.now();
        int age = today.compareTo(outputBirthday);
        while (age < 18 || age >100) {
            System.out.println("Age must be between 18 ~ 100. Please input birthday again:");
            outputBirthday = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            age = today.compareTo(outputBirthday);
        }
        return  outputBirthday;
    }
}
