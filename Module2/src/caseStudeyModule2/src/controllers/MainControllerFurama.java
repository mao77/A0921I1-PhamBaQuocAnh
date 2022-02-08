package controllers;

import java.util.Scanner;

public class MainControllerFurama {
    Scanner scanner = new Scanner(System.in);
    CustomerFuramaController customerFuramaController = new CustomerFuramaController();
    EmployeeFuramaController employeeFuramaController = new EmployeeFuramaController();
    FacilityFuramaController facilityFuramaController = new FacilityFuramaController();
    BookingFuramaController bookingFuramaController = new BookingFuramaController();
    public void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("----------------------MỜI CHỌN MENU------------------:\n" +
                    "1.CUSTOMER MANAGEMENT\n" +
                    "2.EMPLOYEE MANAGEMENT\n" +
                    "3.FACILITY MANAGEMENT\n" +
                    "4.BOOKING MANAGEMENT\n" +
                    "5.EXIT\n"
            );
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //customer management
                    customerFuramaController.displayCustomerFuramaController();
                    break;
                case 2:
                    //employee management
                    employeeFuramaController.displayEmployeeFuramaController();
                    break;
                case 3:
                    //facility management
                     facilityFuramaController.displayFacilityFuramaController();
                    break;
                case 4:
                    //booking management
                    bookingFuramaController.displayBookingFuramaController();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Mời chọn menu:");
                    break;
            }
        } while (flag);
    }
}
