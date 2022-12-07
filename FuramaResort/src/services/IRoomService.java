package services;


import models.Facility;

public interface IRoomService {
    String addNewRoom(Facility newRoom);
    void displayList();


    void displayRoomListMaintenance();
}
