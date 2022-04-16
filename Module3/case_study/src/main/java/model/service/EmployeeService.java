package model.service;

import model.bean.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeService {
    List<Employee> listALl();
    boolean add(Employee employee);
    List<Employee> search(String name,String positionId,String educationDegreeId,String divisionId);
    Employee getById(int id);
    boolean update(Employee employee);
    boolean delete(int id);
}
