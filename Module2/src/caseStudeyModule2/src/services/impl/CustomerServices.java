package services.impl;

import models.Customer;
import models.Employee;
import models.Person;
import services.ICustomerServices;
import util.ReadAndWriteCustomerListToCSV;
import util.ReadAndWriteVillaListToCSV;

import java.sql.Struct;
import java.util.*;

public class CustomerServices implements ICustomerServices {
    private static final String CUSTOMER_PATH_FILE = "D:\\CaseStudeyModule2\\src\\data\\customer.csv";
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Nhập mã khách hàng:");
        String customerID = scanner.nextLine();
        System.out.println("Nhập tên khách hàng:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh khách hàng:");
        String birthDay = scanner.nextLine();
        System.out.println("Nhập giới tính khách hàng:");
        String gender = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập số CMND khách hàng:");
        String passportNumber = scanner.nextLine();
        System.out.println("Nhập emai khách hàng:");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng:");
        String customerType = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng:");
        String address = scanner.nextLine();
        Customer customer = new Customer(name, birthDay, gender, phoneNumber, passportNumber, email, customerID,
                customerType, address);
        List<Customer> customerList = new LinkedList<>();
        customerList.add(customer);
        ReadAndWriteCustomerListToCSV.writeCustomerListToCSV(CUSTOMER_PATH_FILE, customerList, true);
    }

    @Override
    public void display() {
        List<Customer> customerList = new LinkedList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CUSTOMER_PATH_FILE);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void edit() {
        List<Customer> customerList = new LinkedList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CUSTOMER_PATH_FILE);
        display();
        System.out.println("Nhập Customer ID cần sửa:");
        String chooseEdit = scanner.nextLine();
        for (Customer customer:customerList){
            if (Objects.equals(customer.getCustomerID(), chooseEdit)){
                System.out.println("Nhập tên Customer:");
                String name = scanner.nextLine();
                customer.setName(name);
                System.out.println("Nhập ngày sinh Customer:");
                String birthDay = scanner.nextLine();
                customer.setBirthDay(birthDay);
                System.out.println("Nhập giới tính Customer:");
                String gender = scanner.nextLine();
                customer.setGender(gender);
                System.out.println("Nhập số điện thoại Customer:");
                String phoneNumber = scanner.nextLine();
                customer.setPhoneNumber(phoneNumber);
                System.out.println("Nhập số CMND Customer:");
                String passportNumber = scanner.nextLine();
                customer.setIdNumber(passportNumber);
                System.out.println("Nhập emai Customer:");
                String email = scanner.nextLine();
                customer.setEmail(email);
                System.out.println("Nhập loại Customer:");
                String customerType = scanner.nextLine();
                customer.setCustomerType(customerType);
                System.out.println("Nhập địa chỉ Customer:");
                String address = scanner.nextLine();
                customer.setAddress(address);
            }
        }
        ReadAndWriteCustomerListToCSV.writeCustomerListToCSV(CUSTOMER_PATH_FILE,customerList,false);
    }

    @Override
    public void searchByName() {
        List<Customer> customerList = new LinkedList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CUSTOMER_PATH_FILE);
        System.out.println("Nhập tên Customer cần tìm kiếm:");
        String searchName = scanner.nextLine();
        boolean count = true;
        for (Customer customer : customerList) {
            if (customer.getName().contains(searchName)) {
                System.out.println(customer);
                count = false;
            }
        }
        if (count) {
            System.out.println("Không tìm thấy customer nào!");
        }

    }

    @Override
    public void delete() {
        List<Customer> customerList = new LinkedList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CUSTOMER_PATH_FILE);
        display();
        System.out.println("Chọn ID Customer cần xóa:");
        String chooseDelete = scanner.nextLine();
        customerList.removeIf(customer -> Objects.equals(customer.getCustomerID(), chooseDelete));
        ReadAndWriteCustomerListToCSV.writeCustomerListToCSV(CUSTOMER_PATH_FILE, customerList, false);
    }
    public void sortByID() {
        List<Customer> customerList = new ArrayList<>();
        customerList = ReadAndWriteCustomerListToCSV.readCustomerListFromCSV(CUSTOMER_PATH_FILE);
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
               return o1.getCustomerID().compareTo(o2.getCustomerID());
            }
        });
        ReadAndWriteCustomerListToCSV.writeCustomerListToCSV(CUSTOMER_PATH_FILE,customerList,false);
    }

}
