package util;

import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployeeListToCSV {
    public static void writeEmployeeListToCSV(String pathFile, List<Employee> employeeList,boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            stringList.add(employeeList.get(i).getInfoToCSV());
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static List<Employee> readEmployeeListFromCSV(String pathFile){
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        String[] array = null;
        for (String string:stringList) {
            array = string.split(",");
            Employee employee = new Employee(array[1],array[2],array[3],array[4],array[5],
                    array[6],array[0],array[7],array[8],array[9]);
            employeeList.add(employee);
        }
        return employeeList;
    }

}
