package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    void createEmployee(Employee employee);

    Employee findEmployeeById(int id);

    Page<Employee> findAllEmployeeByNativeQuery(String name,String employeePositionId,Pageable pageable);

    Page<Employee> findAllBySalary(double salary, Pageable pageable);
}
