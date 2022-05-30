package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> listAllCustomer(Pageable pageable);
    void createCustomer(Customer customer);
    Customer getCustomerById(int id);
    void editCustomer(Customer customer);
    void deleteCustomerById(int id);
    Page<Customer> findCustomersByNameContainingAndGender_Id(String searchName, int id, Pageable pageable);
}
