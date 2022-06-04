package com.codegym.controller;

import com.codegym.entity.Gender;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.EmployeeDivision;
import com.codegym.entity.employee.EmployeeEducationDegree;
import com.codegym.entity.employee.EmployeePosition;
import com.codegym.repository.GenderRepository;
import com.codegym.repository.employee.EmployeeDivisionRepository;
import com.codegym.repository.employee.EmployeeEducationDegreeRepository;
import com.codegym.repository.employee.EmployeePositionRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private EmployeeDivisionRepository employeeDivisionRepository;

    @Autowired
   private EmployeeEducationDegreeRepository employeeEducationDegreeRepository;

    @Autowired
    private EmployeePositionRepository employeePositionRepository;

    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute
    public List<Gender> genderList(){
        return genderRepository.findAll();
    }

    @ModelAttribute
    public List<EmployeeDivision> employeeDivisionList(){
        return employeeDivisionRepository.findAll();
    }

    @ModelAttribute
    public List<EmployeeEducationDegree> employeeEducationDegreeList(){
        return employeeEducationDegreeRepository.findAll();
    }

    @ModelAttribute
    public List<EmployeePosition> employeePositionList(){
        return employeePositionRepository.findAll();
    }

    @GetMapping("/create")
    public String createEmployeeView(Model model){
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @PostMapping("create")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("")
    public String listEmployee(Model model,
                               @PageableDefault(size = 2) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAllEmployee(pageable);
        model.addAttribute("employeeList",employeeList);
        return "/employee/list";
    }

    @GetMapping("/detail")
    public String detailEmployee(Model model,
                                 @RequestParam int id) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee",employee);
        return "/employee/detail";
    }

    @GetMapping("/search")
    public String searchEmployeeView(){
        return "/employee/search";
    }

    @PostMapping("/search")
    public String searchEmployee(@RequestParam String searchName,
                                 @RequestParam String searchEmployeePosition,
                                 @RequestParam double searchSalary,
                                 Model model,
                                 @PageableDefault(size = 2) Pageable pageable){
        Page<Employee> employeeList = employeeService.findAllBySalary(searchSalary,pageable);
        model.addAttribute("employeeList",employeeList);
        return "/employee/list";
    }
}
