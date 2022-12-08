package models;

import libs.CustomerType;
import java.time.LocalDate;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String id, String fullName, LocalDate birthday, String gender, String identityNumber, String phoneNumber,
                    String email, String customerType, String address) {
        super(id, fullName, birthday, gender, identityNumber, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public boolean setCustomerType(String customerType) {
        customerType = customerType.toUpperCase();
        for (CustomerType custType : CustomerType.values()) {
           if (customerType.equals(custType.name())) {
               this.customerType = customerType;
               return true;
           }
        }
       return false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " id='" + super.getId() + '\'' +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthday=" + super.getBirthdayString() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", identityNumber='" + super.getIdentityNumber() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                "} ";
    }

    public String convertToCSVFormat() {
        return  super.getId() + ',' +
                super.getFullName() + ',' +
                super.getBirthdayString() + ',' +
                super.getGender() + ',' +
                super.getIdentityNumber() + ',' +
                super.getPhoneNumber() + ',' +
                super.getEmail() + ',' +
                customerType + ',' +
                address;
    }
}
