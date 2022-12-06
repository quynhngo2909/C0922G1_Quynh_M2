package services.impl;

import models.Facility;

import models.Villa;
import services.IVillaService;
import utils.Regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VillaServiceImpl implements IVillaService {
    private static final String FACILITY = "Villa";

    public static Map<String, Villa> villaMap = new LinkedHashMap<String, Villa>();
    public static Map<String, Integer> villaMaintenanceMap = new LinkedHashMap<String, Integer>();

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewVilla() {
        String id;
        boolean isUsedID = false;
        do {
            System.out.println("Please input " + FACILITY + " id");
            id = sc.nextLine();
            String idRegex = FACILITY + " ID must be in format \\\"SVVL-YYYY\\\", with YYYY is numbers from 0-9";
            id = Regex.validateInputtedVariable(Regex.FACILITY_VILLA_ID, id, idRegex, FACILITY + " id");
            Villa tempVilla = new Villa(id);
            for (Villa villa : villaMap.values()) {
                if (tempVilla.equals(villa)) {
                    System.out.println("The villa id " + id + " has been used.");
                    isUsedID = true;
                    break;
                } else {
                    isUsedID = false;
                }
            }
        } while (isUsedID);

        System.out.println("Please input " + FACILITY + " name");
        String facilityName = sc.nextLine();
        String nameRegex = FACILITY + " name must begin with a capital character, and normal character onwards.";
        facilityName = Regex.validateInputtedVariable(Regex.FACILITY_NAME, facilityName, nameRegex, FACILITY + " name");

        System.out.println("Please input " + FACILITY + " usable area");
        String usableArea = sc.nextLine();
        String usableAreaRegex = "Usable area must be a real number and bigger than 30";
        usableArea = Regex.validateInputtedVariable(Regex.USABLE_AREA, usableArea, usableAreaRegex, FACILITY + " usable area");

        System.out.println("Please input " + FACILITY + " rental fee");
        String rentalFee = sc.nextLine();
        String rentalFeeRegex = "Rental fee must be a positive real number";
        rentalFee = Regex.validateInputtedVariable(Regex.RENTAL_FEE, rentalFee, rentalFeeRegex, FACILITY + " rental fee");

        System.out.println("Please input " + FACILITY + " maximum capacity");
        String maxCap = sc.nextLine();
        String maxCapRegex = "Maximum capacity must be bigger than 0 and smaller than 20.";
        maxCap = Regex.validateInputtedVariable(Regex.MAX_CAP, maxCap, maxCapRegex, FACILITY + " maximum capacity");

        System.out.println("Please input " + FACILITY + " rental type");
        String rentalType = sc.nextLine();
        String rentalTypeRegex = "Rental type must begin with a capital character, and normal character onwards.";
        rentalType = Regex.validateInputtedVariable(Regex.RENTAL_TYPE, rentalType, rentalTypeRegex, FACILITY + " rental type");

        System.out.println("Please input " + FACILITY + " room standard");
        String roomStandard = sc.nextLine();
        String roomStandardRegex = "Room standard must begin with a capital character, and normal character onwards";
        roomStandard = Regex.validateInputtedVariable(Regex.ROOM_STANDARD, roomStandard, roomStandardRegex, FACILITY + " room standard");

        System.out.println("Please input " + FACILITY + " swimming pool area");
        String swimmingPoolArea = sc.nextLine();
        String spaRegex = "Swimming pool area must be a real number and bigger than 30";
        swimmingPoolArea = Regex.validateInputtedVariable(Regex.SWIMMING_POOL_AREA, swimmingPoolArea, spaRegex, FACILITY + " swimming pool area");

        System.out.println("Please input " + FACILITY + " floor number");
        String floorNumber = sc.nextLine();
        String floorNumberRegex = "Floor number must be a positive real number";
        floorNumber = Regex.validateInputtedVariable(Regex.FLOOR_NUMBER, floorNumber, floorNumberRegex, FACILITY + " floor number");

        Facility newVilla = new Villa(id, facilityName, usableArea, rentalFee, maxCap, rentalType, roomStandard,
                swimmingPoolArea, floorNumber);
        return newVilla.getId();
    }

    @Override
    public void displayList() {
        for (Map.Entry<String, Villa> e : villaMap.entrySet()) {
            System.out.println(e.getValue().toString());
        }
    }

    @Override
    public void displayVillaListMaintenance() {
        for (Map.Entry<String, Integer> e : villaMaintenanceMap.entrySet()) {
            if (e.getValue() >= 5) {
                System.out.println(e.getKey() + " : " + e.getValue() + " using time(s)");
            }
        }
    }
}
