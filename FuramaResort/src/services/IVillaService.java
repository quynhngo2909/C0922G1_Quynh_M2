package services;


import models.Facility;

public interface IVillaService {
    String addNewVilla(Facility villa);
    boolean isUsedID(String id);
}
