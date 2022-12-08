package services;


import models.Facility;

public interface IRoomService {
    String addNewRoom(Facility newRoom);
    boolean isUsedID(String id);
}
