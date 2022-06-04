package com.codegym.controller;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.Service;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.service.ServiceRepository;
import com.codegym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository  employeeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ContractService contractService;

    @ModelAttribute
    private List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @ModelAttribute
    private List<Employee> employeeList(){
        return employeeRepository.findAll();
    }

    @ModelAttribute
    private List<Service> serviceList(){
        return serviceRepository.findAll();
    }

    @GetMapping("")
    public String listAll(Model model,
                          @PageableDefault(size = 2) Pageable pageable){
        Page<Contract> contractList = contractService.findAll(pageable);
        model.addAttribute("contractList",contractList);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String createContractView(Model model){
        model.addAttribute("contract", new Contract());
        return "/contract/create";
    }

    @PostMapping("create")
    public String createContract(@ModelAttribute Contract contract) {
        contractService.createContract(contract);
        return "redirect:/contract";
    }

    @GetMapping("/search")
    public String searchContractView(){
        return "contract/search";
    }

    @PostMapping("/search")
    public String searchContract(@RequestParam String searchId,
                                 @RequestParam String searchCustomerId,
                                 @PageableDefault(size = 2) Pageable pageable,
                                 Model model) {
        Page<Contract> contractList = contractService.findAllByIdAndAndCustomerId(searchId,searchCustomerId,pageable);
        model.addAttribute("contractList",contractList);
        return "/contract/list";
    }
}
