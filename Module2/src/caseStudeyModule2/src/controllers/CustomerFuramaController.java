package controllers;

import services.impl.CustomerServices;

import java.util.Scanner;

public class CustomerFuramaController {
    CustomerServices customerServices = new CustomerServices();
    Scanner scanner = new Scanner(System.in);

    public void displayCustomerFuramaController() {
        boolean flag = true;
        do {
            System.out.printf("---------------CUSTOMER MANAGEMENT---------------\n" +
                    "1.DISPLAY LIST CUSTOMER\n" +
                    "2.ADD NEW CUSTOMER\n" +
                    "3.EDIT CUSTOMER\n" +
                    "4.SEARCH CUSTOMER BY NAME\n" +
                    "5.DELETE CUSTOMER BY ID\n" +
                    "6.SORT LIST CUSTOMER BY ID\n" +
                    "7.EXIT TO MAIN MENU\n"
            );
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    // display list customer
                    System.out.println("Đây là display customer");
                    customerServices.display();
                    break;
                case 2:
                    //add new customer
                    System.out.println("đây là add new customer");
                    customerServices.add();
                    break;
                case 3:
                    //edit customer
                    System.out.println("đây là edit customer");
                    customerServices.edit();
                    break;
                case 4:
                    //search customer
                    System.out.println("đây là search customer");
                    customerServices.searchByName();
                    break;
                case 5:
                    //delete customer
                    System.out.println("đây là delete customer");
                    customerServices.delete();
                    break;
                case 6:
                    System.out.println("đây là sort by id");
                    customerServices.sortByID();
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    break;
            }
        } while (flag);
    }
}
