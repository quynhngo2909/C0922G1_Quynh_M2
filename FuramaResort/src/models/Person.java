package models;

import libs.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String id;
    private String fullName;
    private LocalDate birthday;
    private String gender;
    private String identityNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String id, String fullName, LocalDate birthday, String gender, String identityNumber,
                  String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public boolean setGender(String gender) {
        gender = gender.toUpperCase();
        for (Gender g : Gender.values()) {
            if (gender.equals(g.name())) {
                this.gender = gender;
                return  true;
            }
        }
        return false;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
