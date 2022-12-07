package services.impl;

import models.Facility;
import models.Room;

import services.IFileIO;
import services.IRoomService;
import utils.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RoomServiceImpl implements IRoomService, IFileIO<Facility> {
    private static final String FACILITY = "Room";
    private static final String ROOM_FILE_MAP = "src/data/room.csv";

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewRoom() {
        Map<String, Facility> roomMap = readFile(ROOM_FILE_MAP);
        boolean isUsedID = false;
        String id;
        do {
            System.out.println("Please input " + FACILITY + " id");
            id = sc.nextLine();
            String idRegex = FACILITY + " ID must be in format \\\"SVRO-YYYY\\\", with YYYY is numbers from 0-9";
            id = Regex.validateInputtedVariable(Regex.FACILITY_ROOM_ID, id, idRegex, FACILITY + " id");
            Facility tempRoom = new Room(id);
            for (Facility room : roomMap.values()) {
                if (tempRoom.equals(room)) {
                    System.out.println("The room id " + id + " has been used.");
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

        System.out.println("Please input " + FACILITY + " free charged service");
        String freeChargedService = sc.nextLine();

        Room newRoom = new Room(id, facilityName, usableArea, rentalFee, maxCap, rentalType, freeChargedService);
        roomMap.put(newRoom.getId(), newRoom);
        writeFile(ROOM_FILE_MAP,roomMap);
        return newRoom.getId();
    }

    @Override
    public void displayList() {
        Map<String, Facility> roomMap = readFile(ROOM_FILE_MAP);
        for (Map.Entry<String, Facility> e : roomMap.entrySet()) {
            System.out.println(e.getValue().toString());
        }
    }

    @Override
    public void displayRoomListMaintenance() {
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
        Map<String, Facility> roomMap = new LinkedHashMap<String, Facility>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                roomMap.put(splitLine[0], new Room(splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5],
                        splitLine[6],splitLine[7]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Facility> roomMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Facility> room : roomMap.entrySet()) {
                bw.write(room.getKey() + "," + room.getValue().convertToFormatCSV());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
