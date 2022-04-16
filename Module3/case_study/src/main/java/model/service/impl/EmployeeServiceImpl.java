package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> listALl() {
        return employeeRepository.listAll();
    }

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }

    @Override
    public List<Employee> search(String name, String positionId, String educationDegreeId, String divisionId) {
        return employeeRepository.search(name,positionId,educationDegreeId,divisionId);
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.deleteEmployee(id);
    }
}
