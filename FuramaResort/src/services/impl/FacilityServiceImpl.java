package services.impl;

import models.Facility;
import models.Villa;
import services.IFacilityService;
import services.IFileIO;
import services.IRoomService;
import services.IVillaService;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService, IFileIO<Integer> {
    private Scanner sc = new Scanner(System.in);
    private IVillaService villaService = new VillaServiceImpl();
    private IRoomService roomService = new RoomServiceImpl();
    private static final String FACILITY_FILE_PATH = "src/data/facility_using_list.csv";

    @Override
    public void displayList() {
        Map<String, Integer> facilityMap = readFile(FACILITY_FILE_PATH);
        for (Map.Entry<String, Integer> entry : facilityMap.entrySet()) {
            System.out.println("Facility " + entry.getKey() + " : " + entry.getValue() + " using time(s).");
        }
    }
    @Override
    public void addNewFacility(String facilityID) {
        Map<String, Integer> facilityMap = readFile(FACILITY_FILE_PATH);
        facilityMap.put(facilityID, 0);
        writeFile(FACILITY_FILE_PATH, facilityMap);
    }


    @Override
    public void displayListFacilityMaintenance() {
        Map<String, Integer> facilityMap = readFile(FACILITY_FILE_PATH);
        System.out.println(" Facility Maintenance list:");
        for (Map.Entry<String, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println("Facility " + entry.getKey() + " : " + entry.getValue() + " using time(s).");
            }
        }
    }

    private void validateFilePath(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Map<String, Integer> readFile(String filePath) {
        validateFilePath(filePath);
        Map<String, Integer> facilityMap = new LinkedHashMap<>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                facilityMap.put(splitLine[0], Integer.parseInt(splitLine[1]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Integer> facilityMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Integer> e : facilityMap.entrySet()) {
                bw.write(e.getKey() + "," + e.getValue());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
