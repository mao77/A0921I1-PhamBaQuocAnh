package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import com.codegym.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findAllEmployeeByNativeQuery(String name, String employeePositionId, Pageable pageable) {
        return employeeRepository.findAll(name,employeePositionId,pageable);
    }

    @Override
    public Page<Employee> findAllBySalary(double salary, Pageable pageable) {
        return employeeRepository.findAllBySalary(salary,pageable);
    }
}
