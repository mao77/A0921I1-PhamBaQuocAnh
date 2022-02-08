package services.impl;

import models.*;
import services.IServices;
import sun.awt.image.ImageWatched;
import util.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingServices implements IServices {
    protected final String BOOKING_PATH_FILE = "D:\\CaseStudeyModule2\\src\\data\\booking.csv";
    Scanner scanner = new Scanner(System.in);
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
                if (endDay1.compareTo(endDay2) > 0) {
                    return 1;
                }else if (endDay1.compareTo(endDay2) < 0) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    });

    @Override
    public void add() {
        System.out.println("Nhập booking ID:");
        String bookingID = scanner.nextLine();
        System.out.println("Nhập ngày bắt đầu");
        String startDay = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc");
        String endDay = scanner.nextLine();
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        Booking booking = new Booking(bookingID, startDay, endDay, customer, facility);
        bookingSet.add(booking);
        ReadAndWriteBookingListToCSV.writeBookingListToCSV(BOOKING_PATH_FILE,bookingSet,true);

    }

    @Override
    public void display() {
        Set<Booking> bookingSet = ReadAndWriteBookingListToCSV.readBookingListFromCSV(BOOKING_PATH_FILE);
        for (Booking booking:bookingSet) {
            System.out.println(booking);
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

    private Customer chooseCustomer() {
        CustomerServices customerServices = new CustomerServices();
        List<Customer> customerList = new ArrayList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CustomerServices.CUSTOMER_PATH_FILE);
        customerServices.display();
        boolean flag = true;
        Customer customer = null;
        while (flag) {
            System.out.println("Chọn ID Customer cần Booking");
            String chooseID = scanner.nextLine();
            for (Customer customer1 : customerList) {
                if (customer1.getCustomerID().equals(chooseID)) {
                    customer = customer1;
                    flag = false;
                }
            }
        }
        return customer;
    }

    private Facility chooseFacility() {
        Facility facility = null;
        boolean flag = true;
        while (flag) {
            System.out.println("Mời chọn Facility cần booking:\n" +
                    "1.\tVilla\n" +
                    "2.\tHouse\n" +
                    "3.\tRoom\n"
            );
            int chooseFacility = Integer.parseInt(scanner.nextLine());
            boolean flag1 = true;
            switch (chooseFacility) {
                case 1:
                    //choose villa
                    VillaServices villaServices = new VillaServices();
                    villaServices.display();
                    LinkedHashMap<Villa, Integer> villaList = ReadAndWriteVillaListToCSV.readVillaListFromCSV(VillaServices.VILLA_PATH_FILE);


                    while (flag1) {
                        System.out.println("Chọn villa name");
                        String chooseVilla = scanner.nextLine();
                        for (Villa villa : villaList.keySet()) {
                            if (villa.getName().equals(chooseVilla)) {
                                facility = villa;
                                flag1 = false;
                                flag = false;
                            }
                        }
                    }
                    break;
                case 2:
                    //choose house
                    HouseServices houseServices = new HouseServices();
                    LinkedHashMap<House,Integer> houseMap = ReadAndWriteHouseListToCSV.readHouseListFromCSV(HouseServices.HOUSE_PATH_FILE);
                    houseServices.display();
                    while (flag1){
                        System.out.println("Chọn House Name");
                        String chooseHouse = scanner.nextLine();
                        for (House house:houseMap.keySet()) {
                            if (house.getName().equals(chooseHouse)) {
                                facility = house;
                                flag1 = false;
                                flag = false;
                            }
                            }
                        }
                    break;
                case 3:
                    //choose room
                    LinkedHashMap<Room,Integer> roomMap = ReadAndWriteRoomListToCSV.readRoomListFromCSV(RoomServices.ROOM_PATH_FILE);
                    RoomServices roomServices = new RoomServices();
                    roomServices.display();
                    while (flag1) {
                        System.out.println("Chọn Room Name");
                        String chooseRoom = scanner.nextLine();
                        for (Room room:roomMap.keySet()) {
                            if (room.getName().equals(chooseRoom)) {
                                facility = room;
                                flag1 = false;
                                flag = false;
                            }
                        }
                    }
                    break;
                default:
                    flag = true;
            }

        }
        return facility;
    }
}
