package services.impl;

import services.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static final Scanner sc = new Scanner(System.in);
    RoomServiceImpl roomService = new RoomServiceImpl();
    VillaServiceImpl villaService = new VillaServiceImpl();
    static Map<String, Integer> facilityMaintenance = new LinkedHashMap<String, Integer>();

    @Override
    public void displayList() {
        for (Map.Entry<String, Integer> entry : facilityMaintenance.entrySet()) {
            System.out.println("Facility " + entry.getKey() + " : " + entry.getValue() + " using time(s).");
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
                    String newVillaID = villaService.addNewVilla();
                    facilityMaintenance.put(newVillaID,0);
                    break;
                case 2:
                    System.out.println("Add a new Room");
                    String newRoomId = roomService.addNewRoom();
                    facilityMaintenance.put(newRoomId,0);

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
            if (entry.getValue() >= 5) {
                System.out.println("Facility " + entry.getKey() + " : " + entry.getValue() + " using time(s).");
            }
        }
    }
}
