package com.codegym.repository.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee where name like concat('%',:name,'%') " +
            "and employee_position_id like concat('%',:employee_position_id,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM employee where name like concat('%',:name,'%')  and employee_position_id like concat('%',:employee_position_id,'%') ) abc ")
    Page<Employee> findAll(@Param("name") String name, @Param("employee_position_id") String id, Pageable pageable);

    @Query(value = "SELECT * FROM EMPLOYEE where salary < :salary",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM employee where salary < :salary")
    Page<Employee> findAllBySalary(@Param ("salary") double salary,Pageable pageable);
}
