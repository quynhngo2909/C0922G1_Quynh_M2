package services;

public interface IFacilityService extends IService {
    @Override
    void displayList();
    void addNewFacility();
    void displayListFacilityMaintenance();
}
