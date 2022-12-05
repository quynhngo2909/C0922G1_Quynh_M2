package services.impl;

import models.Facility;
import models.Room;
import models.Villa;
import services.IFacilityService;
import utils.RegularExpression;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
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
        String id;
        do {
            System.out.println("Input the new Villa's id:");
            id = sc.nextLine();
        } while (!RegularExpression.validVillaID(id));

        String facilityName;
        do {
            System.out.println("Input the new Villa's name:");
            facilityName = sc.nextLine();
        }while (!RegularExpression.validFacilityName(facilityName));

        String usableArea;
        do {
            System.out.println("Input the new Villa's usable area:");
            usableArea = sc.nextLine();
        } while (!RegularExpression.validUsableArea(usableArea));

        double doubleUsedArea = Double.parseDouble(usableArea);
        String rentalFee;
        do {
            System.out.println("Input the new Villa's rental fee:");
            rentalFee = sc.nextLine();
        } while (!RegularExpression.validRentalFee(rentalFee));

        double doubleRentalFee = Double.parseDouble(rentalFee);
        String maxCap;
        do {
            System.out.println("Input the new Villa's maximum capacity:");
           maxCap = sc.nextLine();
        } while (!RegularExpression.validMaxCap(maxCap));

        int integerMaxCap = Integer.parseInt(maxCap);
        String rentalType;
        do {
            System.out.println("Input the new Villa's rentalType:");
            rentalType = sc.nextLine();
        } while (!RegularExpression.validRentalType(rentalType));

        String roomStandard;
        do {
            System.out.println("Input the new Villa's room standard:");
            roomStandard = sc.nextLine();
        } while (!RegularExpression.validRoomStandard(roomStandard));

        String swimmingPoolArea;
        do {
            System.out.println("Input swimming pool area");
            swimmingPoolArea = sc.nextLine();
        } while (!RegularExpression.validSwimmingPoolArea(swimmingPoolArea));

        double doubleSwimmingPoolArea = Double.parseDouble(swimmingPoolArea);
        String floorNumber;
        do {
            System.out.println("Input the floor number:");
            floorNumber = sc.nextLine();
        } while (!RegularExpression.validFloorNumber(floorNumber));

        Facility newVilla = new Villa(id, facilityName, doubleUsedArea, doubleRentalFee, integerMaxCap, rentalType,
                roomStandard, doubleSwimmingPoolArea, floorNumber);

        facilityList.put(newVilla.getId(), newVilla);
        return newVilla;
    }

    private Facility addNewRoom() {
        String id;
        do {
            System.out.println("Input the new Room's id:");
            id = sc.nextLine();
        } while (!RegularExpression.validRoomID(id));

        String facilityName;
        do {
            System.out.println("Input the new Room's name:");
            facilityName = sc.nextLine();
        }while (!RegularExpression.validFacilityName(facilityName));

        String usableArea;
        do {
            System.out.println("Input the new Room's usable area:");
            usableArea = sc.nextLine();
        } while (!RegularExpression.validUsableArea(usableArea));

        double doubleUsedArea = Double.parseDouble(usableArea);
        String rentalFee;
        do {
            System.out.println("Input the new Room's rental fee:");
            rentalFee = sc.nextLine();
        } while (!RegularExpression.validRentalFee(rentalFee));

        double doubleRentalFee = Double.parseDouble(rentalFee);
        String maxCap;
        do {
            System.out.println("Input the new Room's maximum capacity:");
            maxCap = sc.nextLine();
        } while (!RegularExpression.validMaxCap(maxCap));

        int integerMaxCap = Integer.parseInt(maxCap);
        String rentalType;
        do {
            System.out.println("Input the new Room's rentalType:");
            rentalType = sc.nextLine();
        } while (!RegularExpression.validRentalType(rentalType));


        System.out.println("Input the free charged service:");
        String freeChargedService = sc.nextLine();
        Facility newRoom = new Room(id, facilityName, doubleUsedArea, doubleRentalFee, integerMaxCap, rentalType,
                freeChargedService);

        facilityList.put(newRoom.getId(), newRoom);
        return newRoom;
    }
}
