package services.impl;

import models.Facility;
import models.Room;
import models.Villa;
import services.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    /*(String id, String facilityName, String usableArea, double rentalFee, int maxCap, String rentalType,
        String roomStandard, String swimmingPoolArea, String floorNumber)*/


    static Scanner sc = new Scanner(System.in);
    static Map<String, Facility> facilityList = new LinkedHashMap<String, Facility>();
    static Map<String, Integer> facilityMaintenance = new LinkedHashMap<String, Integer>();

    @Override
    public void displayList() {
        for (Map.Entry<String, Integer> entry : facilityMaintenance.entrySet()) {
            String facilityID = entry.getKey();
            Integer facilityUsingTime = entry.getValue();
            System.out.println("Facility " + facilityID + " : " + facilityUsingTime + " using time(s).");
        }
    }

    @Override
    public void addNewFacility() {
        do {
            System.out.println("Please choose a facility to be added");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New Room");
            System.out.println("3. Back to menu");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Add a new villa");
                    Facility newVilla = addNewVilla();
                    facilityMaintenance.put(newVilla.getId(), 0);
                    break;
                case 2:
                    System.out.println("Add a new Room");
                    Facility newRoom = addNewRoom();
                    facilityMaintenance.put(newRoom.getId(), 0);
                    break;
                case 3:
                    System.out.println("Back to menu");
                    return;
                default:
                    System.out.println("The option " + choice + " is invalid.");
            }
        } while (true);
    }

    @Override
    public void displayListFacilityMaintenance() {
        System.out.println(" Facility Maintenance list:");
        for (Map.Entry<String, Integer> entry : facilityMaintenance.entrySet()) {
            String facilityID = entry.getKey();
            Integer facilityUsingTime = entry.getValue();
            if (facilityUsingTime >= 5) {
                System.out.println("Facility " + facilityID + " : " + facilityUsingTime + " using time(s).");
            }
        }
    }

    private Facility addNewVilla() {
        System.out.println("Input the new Villa's id:");
        String id = sc.nextLine();
        System.out.println("Input the new Villa's name:");
        String facilityName = sc.nextLine();
        System.out.println("Input the new Villa's usable area:");
        double usableArea = Double.parseDouble(sc.nextLine());
        System.out.println("Input the new Villa's rental fee:");
        double rentalFee = Double.parseDouble(sc.nextLine());
        System.out.println("Input the new Villa's maximum capacity:");
        int maxCap = Integer.parseInt(sc.nextLine());
        System.out.println("Input the new Villa's rentalType:");
        String rentalType = sc.nextLine();
        System.out.println("Input the new Villa's room standard:");
        String roomStandard = sc.nextLine();
        System.out.println("Input swimming pool area");
        double swimmingPoolArea = Double.parseDouble(sc.nextLine());
        System.out.println("Input the floor number:");
        String floorNumber = sc.nextLine();
        Facility newVilla = new Villa(id, facilityName, usableArea, rentalFee, maxCap, rentalType,
                roomStandard, swimmingPoolArea, floorNumber);
        facilityList.put(newVilla.getId(), newVilla);
        return newVilla;
    }

    private Facility addNewRoom() {
        System.out.println("Input the new Room's id:");
        String id = sc.nextLine();
        System.out.println("Input the new Room's name:");
        String facilityName = sc.nextLine();
        System.out.println("Input the new Room's usable area:");
        double usableArea = Double.parseDouble(sc.nextLine());
        System.out.println("Input the new Room's rental fee:");
        double rentalFee = Double.parseDouble(sc.nextLine());
        System.out.println("Input the new Room's maximum capacity:");
        int maxCap = Integer.parseInt(sc.nextLine());
        System.out.println("Input the new Room's rentalType:");
        String rentalType = sc.nextLine();
        System.out.println("Input the free charged service:");
        String freeChargedService = sc.nextLine();
        Facility newRoom = new Room(id, facilityName, usableArea, rentalFee, maxCap, rentalType, freeChargedService);
        facilityList.put(newRoom.getId(), newRoom);
        return newRoom;
    }
}
