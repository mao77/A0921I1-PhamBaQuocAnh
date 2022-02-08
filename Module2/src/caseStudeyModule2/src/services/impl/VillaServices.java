package services.impl;

import models.Villa;
import services.IFacilityServices;
import util.ReadAndWriteStringListToCSV;
import util.ReadAndWriteVillaListToCSV;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class VillaServices implements IFacilityServices {
    public static final String VILLA_PATH_FILE = "D:\\CaseStudeyModule2\\src\\data\\villa.csv";
    Scanner scanner = new Scanner(System.in);
    @Override
    public void displayMaintenanceList() {
        LinkedHashMap<Villa,Integer> villaMap = new LinkedHashMap<>();
        villaMap = ReadAndWriteVillaListToCSV.readVillaListFromCSV(VILLA_PATH_FILE);
        System.out.print("Villa:\t");
        boolean count = true;
        for (Villa villa:villaMap.keySet()) {
            int numberOfUses = villaMap.get(villa);
            if (numberOfUses>=5){
                System.out.print(villa.getName()+"\t");
                count = false;
            }
        }
        if (count) {
            System.out.println("Không có Villa Maintenance");
        }else {
            System.out.println("");
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập tên dịch vụ:");
        String name = scanner.nextLine();
        System.out.println("Nhập diện tích sử dụng:");
        String useArea = scanner.nextLine();
        System.out.println("Nhập chi phí thuê");
        String costRent = scanner.nextLine();
        System.out.println("NHập số lượng người tối đa:");
        String maximumOfNumberPeople = scanner.nextLine();
        System.out.println("Nhập kiểu thuê:");
        String rentType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng:");
        String roomStandard = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi:");
        String poolArea = scanner.nextLine();
        System.out.println("Nhập số tầng:");
        String numberOfFloors = scanner.nextLine();
        Villa villa = new Villa(name,useArea,costRent,maximumOfNumberPeople,rentType,roomStandard,
                poolArea,numberOfFloors);
        int numberOfUses = 0;
        LinkedHashMap<Villa,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(villa,numberOfUses);
        ReadAndWriteVillaListToCSV.writeVillaListToCSV(VILLA_PATH_FILE,linkedHashMap,true);
    }

    @Override
    public void display() {
        LinkedHashMap<Villa,Integer> villaMap = ReadAndWriteVillaListToCSV.readVillaListFromCSV(VILLA_PATH_FILE);
        for (Villa villa: villaMap.keySet()) {
            System.out.println(villa+"-Số lần sử dụng:"+villaMap.get(villa));
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void searchByName() {

    }

    @Override
    public void delete() {

    }
}
