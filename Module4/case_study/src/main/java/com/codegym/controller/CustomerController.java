package com.codegym.controller;


import com.codegym.entity.Gender;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.repository.GenderRepository;
import com.codegym.repository.customer.CustomerTypeRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute
    public List<CustomerType> customerTypeList() {
        List<CustomerType> customerTypeList = customerTypeRepository.findAll();
        return customerTypeList;
    }

    @ModelAttribute
    public List<Gender> genderList() {
        List<Gender> genderList = genderRepository.findAll();
        return genderList;
    }

    @GetMapping("")
    public String customerList(Model model,
                               @PageableDefault(size = 2) Pageable pageable) {
        Page<Customer> customerList = customerService.listAllCustomer(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("create")
    public String createCustomer(@ModelAttribute @Validated Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("edit")
    public String editCustomerView(Model model,
                                   @RequestParam int id) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/edit";
    }

    @PostMapping("edit")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.editCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("detail")
    public String detailCustomer(@RequestParam int id,
                                 Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/detail";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customer";
    }

    @GetMapping("search")
    public String searchCustomerView() {
        return "/customer/search";
    }

    @PostMapping("search")
    public String searchCustomer(Model model,
                                 @RequestParam String searchName,
                                 @RequestParam int searchGender,
                                 @RequestParam int searchCustomerType,
                                 @PageableDefault(size = 2) Pageable pageable) {
        Page<Customer> customerList = customerService.findCustomersByCustomerType_IdAndGenderIdAndNameContaining(
                searchCustomerType, searchGender, searchName, pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }
}
