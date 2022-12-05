package services;

import java.text.ParseException;

public interface ICustomerService extends IService {
    @Override
    void displayList();
    void addNewCustomer();
    void editCustomer();
}
