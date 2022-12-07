package services;

import models.Customer;

import java.text.ParseException;

public interface ICustomerService extends IService {
    void addNewCustomer(Customer o);
    void editCustomer(String editedID);
}
