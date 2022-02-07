package services.impl;

import models.Room;
import services.IFacilityServices;
import util.ReadAndWriteRoomListToCSV;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class RoomServices implements IFacilityServices {
    private static final String ROOM_PATH_FILE = "D:\\CaseStudeyModule2\\src\\data\\room.csv";
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
        System.out.println("NHập dịch vụ miễn phí đi kèm");
        String freeService = scanner.nextLine();
        Room room = new Room(name,useArea,costRent,maximumOfNumberPeople,rentType,freeService);
        int useNumber = 0;
        LinkedHashMap<Room,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(room,useNumber);
        ReadAndWriteRoomListToCSV.writeRoomListToCSV(ROOM_PATH_FILE,linkedHashMap,true);

    }

    @Override
    public void display() {
        LinkedHashMap<Room,Integer> roomMap = new LinkedHashMap<>();
        roomMap = ReadAndWriteRoomListToCSV.readRoomListFromCSV(ROOM_PATH_FILE);
        for (Room room:roomMap.keySet()) {
            System.out.println(room+"-Số lần sử dụng:"+roomMap.get(room));
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
        LinkedHashMap<Room,Integer> roomMap = ReadAndWriteRoomListToCSV.readRoomListFromCSV(ROOM_PATH_FILE);
        System.out.print("Room:\t");
        boolean count = true;
        for (Room room:roomMap.keySet()) {
            int numberOfUses = roomMap.get(room);
            if (numberOfUses>=3){
                System.out.print(room.getName()+"\t");
                count = false;
            }
        }
        if (count) {
            System.out.print("Không có Room Maintenance\n");
        }else {
            System.out.println("");
        }
    }
}
