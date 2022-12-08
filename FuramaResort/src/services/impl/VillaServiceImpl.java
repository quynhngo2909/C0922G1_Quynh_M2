package services.impl;

import models.Facility;

import models.Villa;
import services.IFileIO;
import services.IVillaService;
import utils.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VillaServiceImpl implements IVillaService, IFileIO<Facility> {
    private static final String FACILITY = "Villa";
    private static final String VILLA_FILE_PATH = "src/data/villa.scv";
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewVilla(Facility newVilla) {
        Map<String, Facility> villaMap = readFile(VILLA_FILE_PATH);
        boolean isUsedID = false;
        String tempId = newVilla.getId();

        do {
            for (String villaId : villaMap.keySet()) {
                if (tempId.equals(villaId)) {
                    System.out.println("The villa id " + tempId + " has been used. Please input new villa id");
                    isUsedID = true;
                    tempId = sc.nextLine();
                    break;
                } else {
                    isUsedID = false;
                }
            }
        } while (isUsedID);

        newVilla.setId(tempId);

        villaMap.put(newVilla.getId(), newVilla);
        writeFile(VILLA_FILE_PATH, villaMap);
        return newVilla.getId();
    }

//    @Override
//    public void displayList() {
//        Map<String, Facility> villaMap = readFile(VILLA_FILE_PATH);
//        for (Map.Entry<String, Facility> e : villaMap.entrySet()) {
//            System.out.println(e.getValue().toString());
//        }
//    }

//    @Override
//    public void displayVillaListMaintenance() {
//    }

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
    public Map<String, Facility> readFile(String filePath) {
        validateFilePath(filePath);
        Map<String, Facility> villaMap = new LinkedHashMap<String, Facility>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                villaMap.put(splitLine[0], new Villa(splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5],
                        splitLine[6],splitLine[7],splitLine[8],splitLine[9]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return villaMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Facility> villaMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Facility> villa : villaMap.entrySet()) {
                bw.write(villa.getKey() + "," + villa.getValue().convertToFormatCSV());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
