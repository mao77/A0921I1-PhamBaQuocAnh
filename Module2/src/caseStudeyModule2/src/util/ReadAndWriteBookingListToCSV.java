package util;

import models.*;
import services.impl.CustomerServices;
import services.impl.HouseServices;
import services.impl.RoomServices;
import services.impl.VillaServices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadAndWriteBookingListToCSV {
    public static void writeBookingListToCSV(String pathFile,Set<Booking> bookingSet,boolean append){
        System.out.println("WRITE BOOKING LIST TO CSV...");
        List<String> stringList = new ArrayList<>();
        for (Booking booking : bookingSet) {
            stringList.add(booking.getInfoToCSV());
        }
        ReadAndWriteStringListToCSV.writeStringListToCSV(pathFile,stringList,append);
    }
    public static Set<Booking> readBookingListFromCSV(String pathFile){
        LinkedHashMap<Villa,Integer> villaMap = ReadAndWriteVillaListToCSV.readVillaListFromCSV(VillaServices.VILLA_PATH_FILE);
        LinkedHashMap<House,Integer> houseMap = ReadAndWriteHouseListToCSV.readHouseListFromCSV(HouseServices.HOUSE_PATH_FILE);
        LinkedHashMap<Room,Integer> roomMap = ReadAndWriteRoomListToCSV.readRoomListFromCSV(RoomServices.ROOM_PATH_FILE);
        List<Customer> customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CustomerServices.CUSTOMER_PATH_FILE);
        List<String> stringList = ReadAndWriteStringListToCSV.readStringListFromCSV(pathFile);
        Set<Booking> bookingSet = new TreeSet<>(new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate startDay1 = LocalDate.parse(o1.getStartDay(),dateTimeFormatter);
                LocalDate startDay2 = LocalDate.parse(o2.getStartDay(),dateTimeFormatter);
                LocalDate endDay1 = LocalDate.parse(o1.getEndDay(),dateTimeFormatter);
                LocalDate endDay2 = LocalDate.parse(o2.getEndDay(),dateTimeFormatter);

                if (startDay1.compareTo(startDay2) > 0) {
                    return 1;
                }else if (startDay1.compareTo(startDay2) < 0 ) {
                    return -1;
                }else {
                    return Integer.compare(endDay1.compareTo(endDay2), 0);
                }
            }
        });
        String[] arr = null;
        LinkedHashMap<Facility,Integer> facilityIntegerLinkedHashMap = new LinkedHashMap<>();
        for (Villa villa: villaMap.keySet()) {
            facilityIntegerLinkedHashMap.put(villa,villaMap.get(villa));
        }
        for (Room room: roomMap.keySet()) {
            facilityIntegerLinkedHashMap.put(room, roomMap.get(room));
        }
        for (House house: houseMap.keySet()) {
            facilityIntegerLinkedHashMap.put(house, houseMap.get(house));
        }
        for (String str:stringList) {
            Customer customer = null;
            Facility facility = null;
            arr = str.split(",");
            for (Customer customer1:customerList) {
                 if (customer1.getCustomerID().equals(arr[3])) {
                     customer = customer1;
                 }
            }
            for (Facility facility1:facilityIntegerLinkedHashMap.keySet()) {
                if (facility1.getName().equals(arr[4])){
                    facility = facility1;
                }
            }
            bookingSet.add(new Booking(arr[0],arr[1],arr[2],customer,facility));
        }
        return bookingSet;

    }
}
