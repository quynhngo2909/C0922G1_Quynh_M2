package models;

import java.util.Objects;

public abstract class Facility {
    private String id;
    private String facilityName;
    private String usableArea;
    private String rentalFee;
    private String maxCap;
    private String rentalType;

    protected Facility() {
    }

    protected Facility(String id) {
        this.id = id;
    }

    public Facility(String id, String facilityName, String usableArea, String rentalFee, String maxCap,
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

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public String getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(String rentalFee) {
        this.rentalFee = rentalFee;
    }

    public String getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(String maxCap) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(id, facility.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String convertToFormatCSV() {
        return  id + ',' +
                facilityName + ',' +
                usableArea + ',' +
                rentalFee + ',' +
                maxCap + ',' +
                rentalType;
    }
}
