package services.impl;

import models.Employee;
import services.IEmployeeServices;
import util.ReadAndWriteEmployeeListToCSV;
import util.ReadAndWriteStringListToCSV;

import java.util.*;

public class EmployeeServices implements IEmployeeServices {
    protected final String EMPLOYEE_PATH_FILE ="D:\\CaseStudeyModule2\\src\\data\\employee.csv";
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add() {
        System.out.println("Nhập mã nhân viên:");
        String employeeID = scanner.nextLine();
        System.out.println("Nhập tên nhân viên:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh nhân viên:");
        String birthDay = scanner.nextLine();
        System.out.println("Nhập giới tính nhân viên:");
        String gender = scanner.nextLine();
        System.out.println("Nhập số điện thoại nhân viên:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập số CMND nhân viên:");
        String passportNumber = scanner.nextLine();
        System.out.println("Nhập emai nhân viên:");
        String email = scanner.nextLine();
        System.out.println("Nhập trình độ nhân viên:");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí nhân viên:");
        String position = scanner.nextLine();
        System.out.println("Nhập lương nhân viên:");
        String salary = scanner.nextLine();
        Employee employee = new Employee(name,birthDay,gender,phoneNumber,passportNumber,email,
                employeeID,level,position,salary);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        ReadAndWriteEmployeeListToCSV.writeEmployeeListToCSV(EMPLOYEE_PATH_FILE,employeeList,true);
    }


    @Override
    public void display() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList =ReadAndWriteEmployeeListToCSV.readEmployeeListFromCSV(EMPLOYEE_PATH_FILE);
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = ReadAndWriteEmployeeListToCSV.readEmployeeListFromCSV(EMPLOYEE_PATH_FILE);
        display();
        System.out.println("Nhập ID Employee cần sửa:");
        String chooseEdit = scanner.nextLine();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeID(),chooseEdit)) {
                System.out.println("Nhập tên Employee:");
                String name = scanner.nextLine();
                employee.setName(name);
                System.out.println("Nhập ngày sinh Employee:");
                String birthDay = scanner.nextLine();
                employee.setBirthDay(birthDay);
                System.out.println("Nhập giới tính Employee:");
                String gender = scanner.nextLine();
                employee.setGender(gender);
                System.out.println("Nhập số điện thoại Employee:");
                String phoneNumber = scanner.nextLine();
                employee.setPhoneNumber(phoneNumber);
                System.out.println("Nhập số CMND Employee:");
                String passportID = scanner.nextLine();
                employee.setIdNumber(passportID);
                System.out.println("Nhập email Employee:");
                String email = scanner.nextLine();
                employee.setEmail(email);
                System.out.println("Nhập trình độ Employee:");
                String level = scanner.nextLine();
                employee.setLevel(level);
                System.out.println("Nhập vị trí Employee:");
                String position = scanner.nextLine();
                employee.setPosition(position);
                System.out.println("Nhập lương Employee:");
                String salary = scanner.nextLine();
                employee.setSalary(salary);
            }
        }
        ReadAndWriteEmployeeListToCSV.writeEmployeeListToCSV(EMPLOYEE_PATH_FILE,employeeList,false);
    }

    @Override
    public void searchByName() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = ReadAndWriteEmployeeListToCSV.readEmployeeListFromCSV(EMPLOYEE_PATH_FILE);
        System.out.println("Nhập tên Employee cần tìm kiếm:");
        String searchName = scanner.nextLine();
        boolean count = true;
        for (Employee employee : employeeList) {
            if (employee.getName().contains(searchName)) {
                System.out.println(employee);
                count = false;
            }
        }
        if (count) {
            System.out.println("Không tìm thấy Employee nào!");
        }
    }

    @Override
    public void delete() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = ReadAndWriteEmployeeListToCSV.readEmployeeListFromCSV(EMPLOYEE_PATH_FILE);
        display();
        System.out.println("Chọn ID Employee cần xóa:");
        String chooseDelete = scanner.nextLine();
        employeeList.removeIf(employee -> Objects.equals(employee.getEmployeeID(), chooseDelete));
        ReadAndWriteEmployeeListToCSV.writeEmployeeListToCSV(EMPLOYEE_PATH_FILE,employeeList,false);
    }
    public void sortByID(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList = ReadAndWriteEmployeeListToCSV.readEmployeeListFromCSV(EMPLOYEE_PATH_FILE);
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getEmployeeID().compareTo(o2.getEmployeeID());
            }
        });
        ReadAndWriteEmployeeListToCSV.writeEmployeeListToCSV(EMPLOYEE_PATH_FILE,employeeList,false);
    }
}
