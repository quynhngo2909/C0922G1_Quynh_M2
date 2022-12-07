package services.impl;

import models.Facility;

import models.Villa;
import services.IFileIO;
import services.IVillaService;
import utils.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VillaServiceImpl implements IVillaService, IFileIO<Facility> {
    private static final String FACILITY = "Villa";
    private static final String VILLA_FILE_PATH = "src/data/villa.scv";
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewVilla() {
        Map<String, Facility> villaMap = readFile(VILLA_FILE_PATH);
        String id;
        boolean isUsedID = false;
        do {
            System.out.println("Please input " + FACILITY + " id");
            id = sc.nextLine();
            String idRegex = FACILITY + " ID must be in format \\\"SVVL-YYYY\\\", with YYYY is numbers from 0-9";
            id = Regex.validateInputtedVariable(Regex.FACILITY_VILLA_ID, id, idRegex, FACILITY + " id");
            Facility tempVilla = new Villa(id);
            for (Facility villa : villaMap.values()) {
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

        villaMap.put(newVilla.getId(), newVilla);
        writeFile(VILLA_FILE_PATH, villaMap);
        return newVilla.getId();
    }

    @Override
    public void displayList() {
        Map<String, Facility> villaMap = readFile(VILLA_FILE_PATH);
        for (Map.Entry<String, Facility> e : villaMap.entrySet()) {
            System.out.println(e.getValue().toString());
        }
    }

    @Override
    public void displayVillaListMaintenance() {
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
    public Map<String, Facility> readFile(String filePath) {
        validateFilePath(filePath);
        Map<String, Facility> villaMap = new LinkedHashMap<String, Facility>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                villaMap.put(splitLine[0], new Villa(splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5],
                        splitLine[6],splitLine[7],splitLine[8],splitLine[9]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return villaMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Facility> villaMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Facility> villa : villaMap.entrySet()) {
                bw.write(villa.getKey() + "," + villa.getValue().convertToFormatCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
