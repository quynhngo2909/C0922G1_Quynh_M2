package services;

import models.Customer;

import java.text.ParseException;

public interface ICustomerService extends IService {
    void addNewCustomer(Customer o);
    void editCustomer(Customer o);

    boolean isIdUsed(String id);
    boolean isCoincidentIdentityNumber(String identityNumber);
}
