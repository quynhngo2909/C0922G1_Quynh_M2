package models;

public class Room extends Facility{
    private String freeChargedService;

    public Room() {
    }

    public Room(String id, String facilityName, double usableArea, double rentalFee, int maxCap, String rentalType,
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
