package util;

import models.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomerListToCSV {
    public static void writeCustomerListToCSV(String pathFile, List<Customer> customerList, boolean append){
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            stringList.add(customerList.get(i).getInfoToCSV());
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static List<Customer> readCustomerListFromCSV(String pathFile) {
        List<Customer> customerList = new LinkedList<>();
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        String[] array = null;
        for (String str:stringList) {
            array = str.split(",");
            Customer customer = new Customer(array[1],array[2],array[3],array[4],array[5],array[6],
                    array[0],array[7],array[8]);
            customerList.add(customer);
        }
        return customerList;
    }
}
