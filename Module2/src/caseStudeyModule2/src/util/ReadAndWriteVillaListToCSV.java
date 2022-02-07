package util;

import models.Villa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadAndWriteVillaListToCSV {
    public static void writeVillaListToCSV(String pathFile, LinkedHashMap<Villa,Integer> villaMap,boolean append){
        List<String> stringList = new ArrayList<>();
        for (Villa villa: villaMap.keySet()) {
            stringList.add(villa.getInfoToCSV()+","+villaMap.get(villa));
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static LinkedHashMap<Villa,Integer> readVillaListFromCSV(String pathFile) {
        LinkedHashMap<Villa,Integer> villaMap = new LinkedHashMap<>();
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        String[] array = null;
        for (String str:stringList) {
            array = str.split(",");
            Villa villa = new Villa(array[0],array[1],array[2],array[3],array[4],array[5],
                    array[6],array[7]);
            villaMap.put(villa, Integer.valueOf(array[8]));
        }
        return villaMap;
    }
}
