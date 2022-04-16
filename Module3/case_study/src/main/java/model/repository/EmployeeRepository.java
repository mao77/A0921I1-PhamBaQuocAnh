package model.repository;

import model.bean.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> listAll();
    boolean add(Employee employee);
    List<Employee> search(String name,String positionId,String educationDegreeId,String divisionId);
    Employee getById(int id);
    boolean update(Employee employee);
    boolean deleteEmployee(int id);
}
