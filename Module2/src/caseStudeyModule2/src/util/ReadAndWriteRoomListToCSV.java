package util;

import models.Room;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadAndWriteRoomListToCSV {
    public static void writeRoomListToCSV(String pathFile, LinkedHashMap<Room, Integer> roomList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Room room : roomList.keySet()) {
            stringList.add(room.getInfoToCSV() + "," + roomList.get(room));
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static LinkedHashMap<Room,Integer> readRoomListFromCSV(String pathFile) {
        LinkedHashMap<Room,Integer> roomMap = new LinkedHashMap<>();
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        String[] array = null;
        for (String str:stringList) {
            array = str.split(",");
            Room room = new Room(array[0],array[1],array[2],array[3],array[4],array[5]);
            roomMap.put(room, Integer.valueOf(array[6]));
        }
        return roomMap;
    }
}
