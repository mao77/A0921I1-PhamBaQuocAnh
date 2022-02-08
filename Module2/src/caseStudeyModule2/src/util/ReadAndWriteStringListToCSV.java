package util;

import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStringListToCSV {
    protected static void writeStringListToCSV(String pathFile, List<String> stringList,boolean append){
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < stringList.size(); i++) {
                bufferedWriter.write(stringList.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    protected static List<String> readStringListFromCSV(String pathFile){
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
//            int count = 1;
            while ((line = bufferedReader.readLine())!=null){
//                if (count!=1){
                    stringList.add(line);
//                    array = line.split(",");
//                    Employee employee = new Employee(array[1],array[2],array[3],array[4],array[5],array[6],
//                            array[0],array[7],array[8],array[9]);
//                    employeeList.add(employee);
//                }
//                count ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringList;
    }
}
