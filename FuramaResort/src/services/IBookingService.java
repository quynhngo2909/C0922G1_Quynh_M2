package services;

public interface IBookingService extends IService {
    @Override
    void displayList();
    void addNewBooking();
}
