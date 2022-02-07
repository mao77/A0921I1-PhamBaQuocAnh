package util;

import models.House;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadAndWriteHouseListToCSV {
    public static void writeHouseListToCSV(String pathFile, LinkedHashMap<House,Integer> houseMap,boolean append){
        List<String> stringList = new ArrayList<>();
        for (House house: houseMap.keySet()) {
            stringList.add(house.getInfoToCSV()+","+houseMap.get(house));
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static LinkedHashMap<House,Integer> readHouseListFromCSV(String pathFile){
        LinkedHashMap<House,Integer> houseMap = new LinkedHashMap<>();
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        String[] array = null;
        for (String str:stringList) {
            array = str.split(",");
            House house = new House(array[0],array[1],array[2],array[3],array[4],array[5],array[6]);
            houseMap.put(house, Integer.valueOf(array[7]));
        }
        return houseMap;
    }
}
