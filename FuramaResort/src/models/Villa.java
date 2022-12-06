package models;

public class Villa extends Facility{
    private String roomStandard;
    private String swimmingPoolArea;
    private String floorNumber;

    public Villa() {
    }

    public Villa(String id) {
        super(id);
    }

    public Villa(String id, String facilityName, String usableArea, String rentalFee, String maxCap, String rentalType,
                 String roomStandard, String swimmingPoolArea, String floorNumber) {
        super(id, facilityName, usableArea, rentalFee, maxCap, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(String swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id='" + super.getId() + '\'' +
                ", facilityName='" + super.getFacilityName() + '\'' +
                ", usableArea='" + super.getUsableArea() + '\'' +
                ", rentalFee=" + super.getRentalFee() +
                ", maxCap=" + super.getMaxCap() +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea='" + swimmingPoolArea + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                "} ";
    }
}
