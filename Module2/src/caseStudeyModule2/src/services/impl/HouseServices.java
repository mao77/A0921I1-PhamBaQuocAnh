package services.impl;

import models.House;
import services.IFacilityServices;
import util.ReadAndWriteHouseListToCSV;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class HouseServices implements IFacilityServices {
    public static final String HOUSE_PATH_FILE = "D:\\CaseStudeyModule2\\src\\data\\house.csv";
    Scanner scanner = new Scanner(System.in);

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
        System.out.println("Nhập số tầng:");
        String numberOfFloors = scanner.nextLine();
        House house = new House(name, useArea, costRent, maximumOfNumberPeople, rentType, roomStandard, numberOfFloors);
        int useNumber = 0;
        LinkedHashMap<House, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(house, useNumber);
        ReadAndWriteHouseListToCSV.writeHouseListToCSV(HOUSE_PATH_FILE, linkedHashMap, true);
    }

    @Override
    public void display() {
        LinkedHashMap<House, Integer> houseMap = new LinkedHashMap<>();
        houseMap = ReadAndWriteHouseListToCSV.readHouseListFromCSV(HOUSE_PATH_FILE);
        for (House house : houseMap.keySet()) {
            System.out.println(house + "-Số lần sử dụng:" + houseMap.get(house));
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

    @Override
    public void displayMaintenanceList() {
        LinkedHashMap<House, Integer> houseMap = ReadAndWriteHouseListToCSV.readHouseListFromCSV(HOUSE_PATH_FILE);
        boolean count = true;
        System.out.print("House:\t");
        for (House house : houseMap.keySet()) {
            int numberOfUses = houseMap.get(house);
            if (numberOfUses >= 5) {
                System.out.print(house.getName() + "\t");
                count = false;
            }
        }
        if (count) {
            System.out.print("Không có House Maintenance\n");
        }else {
            System.out.println("");
        }
    }
}
