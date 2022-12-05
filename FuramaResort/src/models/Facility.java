package models;

public abstract class Facility {
    private String id;
    private String facilityName;
    private double usableArea;
    private double rentalFee;
    private int maxCap;
    private String rentalType;

    public Facility() {
    }

    public Facility(String id, String facilityName, double usableArea, double rentalFee, int maxCap,
                    String rentalType) {
        this.id = id;
        this.facilityName = facilityName;
        this.usableArea = usableArea;
        this.rentalFee = rentalFee;
        this.maxCap = maxCap;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                "facilityName='" + facilityName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxCap=" + maxCap +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
