package controllers;

import services.impl.HouseServices;
import services.impl.RoomServices;
import services.impl.VillaServices;

import java.util.Scanner;

public class FacilityFuramaController {
    Scanner scanner = new Scanner(System.in);
    RoomServices roomServices = new RoomServices();
    HouseServices houseServices = new HouseServices();
    VillaServices villaServices = new VillaServices();
    public void displayFacilityFuramaController() {
        boolean flag = true;
        do {
            System.out.println("---------------FACILITY SERVICE--------------\n" +
                    "1.DISPLAY LIST FACILITY\n" +
                    "2.ADD NEW FACILTY\n" +
                    "3.DISPLAY LIST FACILITY MAINTENANCE\n" +
                    "4.RETURN MAIN MENU"
            );
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //display list facility
                    System.out.println("đây là display list facility");
                    roomServices.display();
                    houseServices.display();
                    villaServices.display();
                    break;
                case 2:
                    //add new facility
                    boolean flag2 = true;
                    while (flag2)  {
                        System.out.println("đây là add new facility");
                        System.out.println("-----------ADD NEW FACILITY--------\n"+
                                "1.ADD NEW VILLA\n"+
                                "2.ADD NEW HOUSE\n"+
                                "3.ADD NEW ROOM\n"+
                                "4.RETURN TO FACILITY MANAGEMENT\n"
                        );
                        chooseMenu = Integer.parseInt(scanner.nextLine());
                        switch (chooseMenu) {
                            case 1:
                                //add new villa
                                System.out.println("Đây là add new villa");
                                villaServices.add();
                                break;
                            case 2:
                                //add new house
                                System.out.println("Đây là add new house");
                                houseServices.add();
                                break;
                            case 3:
                                //add new room
                                System.out.println("Đây là add new room");
                                roomServices.add();
                                break;
                            case 4:
                                //return facility management
                                flag2 = false;
                                break;
                            default:
                                flag2 = true;
                                break;
                        }
                    }

                    break;
                case 3:
                    //display list facility maintenance
                    System.out.println("đây là display list facility maintenance");
                    roomServices.displayMaintenanceList();
                    houseServices.displayMaintenanceList();
                    villaServices.displayMaintenanceList();
                case 4:
                    //return main menu
                    flag = false;
                    break;
                default:
                    flag = true;
            }
        }while (flag);
    }
}
