package models;

import java.util.Objects;

public class Room extends Facility{
    private String freeChargedService;

    public Room() {
    }

    public Room(String id) {
        super(id);
    }

    public Room(String id, String facilityName, String usableArea, String rentalFee, String maxCap, String rentalType,
                String freeChargedService) {
        super(id, facilityName, usableArea, rentalFee, maxCap, rentalType);
        this.freeChargedService = freeChargedService;
    }

    public String getFreeChargedService() {
        return freeChargedService;
    }

    public void setFreeChargedService(String freeChargedService) {
        this.freeChargedService = freeChargedService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + super.getId() + '\'' +
                ", facilityName='" + super.getFacilityName() + '\'' +
                ", usableArea='" + super.getUsableArea() + '\'' +
                ", rentalFee=" + super.getRentalFee() +
                ", maxCap=" + super.getMaxCap() +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", freeChargedService='" + this.freeChargedService + '\'' +
                "} ";
    }
}
