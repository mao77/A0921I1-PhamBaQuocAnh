package controllers;

import services.impl.BookingServices;

import java.util.Scanner;

public class BookingFuramaController {
    Scanner scanner = new Scanner(System.in);
    BookingServices bookingServices = new BookingServices();
    public void displayBookingFuramaController() {
        boolean flag = true;
        do {
            System.out.println("---------------BOOKING MANAGEMENT-------------\n" +
                    "1.\tADD NEW BOOKING\n" +
                    "2.\tDISPLAY LIST BOOKING\n" +
                    "3.\tCREAT NEW CONTRACT\n" +
                    "4.\tDISPLAY LIST CONTRACTS\n" +
                    "5.\tEDIT CONTRACTS\n" +
                    "6.\tRETURN MAIN MENU\n"
            );
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //add new contract
                    System.out.println("ADD NEW BOOKING");
                    bookingServices.add();
                    break;
                case 2:
                    //display list contract
                    System.out.println("DISPLAY LIST BOOKING");
                    bookingServices.display();
                    break;
                case 3:
                    //create new contract
                    System.out.println("CREATE NEW CONTRACT");
                    break;
                case 4:
                    //display list contract
                    System.out.println("DISPLAY LIST CONTRACTS");
                    break;
                case 5:
                    //edit contract
                    System.out.println("EDIT CONTRACT");
                    break;
                case 6:
                    //return main menu
                    flag = false;
                    break;
                default:
                    System.out.println("Mời chọn menu");
                    break;

            }
        }while (flag);

    }
}
