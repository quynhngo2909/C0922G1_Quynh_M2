package services;


import models.Facility;
import models.Villa;

public interface IVillaService {
    String addNewVilla(Facility villa);
    void displayList();
    void displayVillaListMaintenance();
}
