package models;

import java.time.LocalDate;

public class Booking {
//    mã booking, ngày bắt đầu, ngày kết thúc, mã khách hàng, tên dịch vụ.

    private String bookingID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerID;
    private String serviceName;

    public Booking() {
    }

    public Booking(String bookingID, LocalDate startDate, LocalDate endDate, String customerID, String serviceName) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.serviceName = serviceName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customerID='" + customerID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
