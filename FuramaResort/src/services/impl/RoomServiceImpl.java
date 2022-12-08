package services.impl;

import models.Facility;
import models.Room;

import services.IFileIO;
import services.IRoomService;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RoomServiceImpl implements IRoomService, IFileIO<Facility> {
    private static final String FACILITY = "Room";
    private static final String ROOM_FILE_MAP = "src/data/room.csv";

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String addNewRoom(Facility newRoom) {
        Map<String, Facility> roomMap = readFile(ROOM_FILE_MAP);
        roomMap.put(newRoom.getId(), newRoom);
        writeFile(ROOM_FILE_MAP,roomMap);
        return newRoom.getId();
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
    public Map<String, Facility> readFile(String filePath) {
        validateFilePath(filePath);
        Map<String, Facility> roomMap = new LinkedHashMap<String, Facility>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(",");
                roomMap.put(splitLine[0], new Room(splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5],
                        splitLine[6],splitLine[7]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomMap;
    }

    @Override
    public void writeFile(String filePath, Map<String, Facility> roomMap) {
        validateFilePath(filePath);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Map.Entry<String, Facility> room : roomMap.entrySet()) {
                bw.write(room.getKey() + "," + room.getValue().convertToFormatCSV());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isUsedID(String id) {
        Map<String, Facility> roomMap = readFile(ROOM_FILE_MAP);
            for (String roomID : roomMap.keySet()) {
                if (id.equals(roomID)) {
                    System.out.println("The room id " + id + " has been used.");
                    return true;
                }
            }
            return false;
    }
}
