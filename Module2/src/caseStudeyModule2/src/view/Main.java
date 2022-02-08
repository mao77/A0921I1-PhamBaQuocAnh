package view;

import controllers.MainControllerFurama;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MainControllerFurama mainControllerFurama = new MainControllerFurama();
        mainControllerFurama.displayMainMenu();
//        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//        try {
//            System.out.println("Nhập ngày bắt đầu");
//            Date date1 = myFormat.parse(scanner.nextLine());
//            System.out.println("Nhập ngày kết thúc");
//            Date date2 = myFormat.parse(scanner.nextLine());
//            long diff = date2.getTime() - date1.getTime();
//            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
