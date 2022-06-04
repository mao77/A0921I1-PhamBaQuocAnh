package com.codegym.repository.employee;

import com.codegym.entity.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition,Integer> {
}
