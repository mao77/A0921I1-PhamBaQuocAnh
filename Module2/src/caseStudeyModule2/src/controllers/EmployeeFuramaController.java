package controllers;

import services.impl.EmployeeServices;

import java.util.Scanner;

public class EmployeeFuramaController {
    EmployeeServices employeeServices = new EmployeeServices();
    Scanner scanner = new Scanner(System.in);
    public void displayEmployeeFuramaController() {
       boolean flag = true;
       do {
           System.out.println("----------------EMPLOYEE MANAGEMENT-----------------\n" +
                   "1.DISPLAY LIST EMPLOYEES\n" +
                   "2.ADD NEW EMPLOYEE\n" +
                   "3.EDIT EMPLOYEE\n" +
                   "4.SEARCH EMPLOYEE BY NAME\n" +
                   "5.DELETE EMPLOYEE BY ID\n" +
                   "6.EXIT TO MAIN MENU\n"
           );
           int chooseMenu = Integer.parseInt(scanner.nextLine());
           switch (chooseMenu) {
               case 1:
                   //display list employee
                   employeeServices.display();
                   break;
               case 2:
                   //add new employee
                   System.out.println("đây là add new employee");
                   employeeServices.add();
                   break;
               case 3:
                   //edit employee
                   System.out.println("đây là edit employee");
                   employeeServices.edit();
                   break;
               case 4:
                   //search employee by name
                   System.out.println("đây là search employee");
                   employeeServices.searchByName();
                   break;
               case 5:
                   //delete employee by name
                   System.out.println("đây là delete employee");
                   employeeServices.delete();
                   break;
               case 6:
                   flag = false;
                   break;
               default:
                   break;
           }
       }while (flag);
    }
}
