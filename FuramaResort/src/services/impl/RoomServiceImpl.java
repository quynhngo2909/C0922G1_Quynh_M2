package services.impl;

import models.Room;

import services.IRoomService;
import utils.Regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RoomServiceImpl implements IRoomService {
    private static final String FACILITY = "Room";

    public static  Map<String, Room> roomMap = new LinkedHashMap<String, Room>();
    public static Map<String, Integer> roomMaintenanceMap = new LinkedHashMap<String, Integer>();

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewRoom() {
        boolean isUsedID = false;
        String id;
        do {
            System.out.println("Please input " + FACILITY + " id");
            id = sc.nextLine();
            String idRegex = FACILITY + " ID must be in format \\\"SVRO-YYYY\\\", with YYYY is numbers from 0-9";
            id = Regex.validateInputtedVariable(Regex.FACILITY_ROOM_ID, id, idRegex, FACILITY + " id");
            Room tempRoom = new Room(id);
            for (Room room : roomMap.values()) {
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
        rentalType = Regex.validateInputtedVariable(Regex.RENTAL_TYPE, rentalType, rentalTypeRegex,FACILITY + " rental type" );

        System.out.println("Please input " + FACILITY + " free charged service");
        String freeChargedService = sc.nextLine();

        Room newRoom = new Room(id, facilityName, usableArea, rentalFee, maxCap, rentalType, freeChargedService);
        roomMap.put(newRoom.getId(), newRoom);
        roomMaintenanceMap.put(newRoom.getId(),0);

        return newRoom.getId();
    }

    @Override
    public void displayList() {
        for (Map.Entry<String, Room> e : roomMap.entrySet()) {
            System.out.println(e.getValue().toString());
        }
    }

    @Override
    public void displayRoomListMaintenance() {
        for (Map.Entry<String, Integer> e : roomMaintenanceMap.entrySet()) {
            if (e.getValue() >= 5) {
                System.out.println(e.getKey() + " : " + e.getValue() + " using time(s)");
            }
        }
    }
}
