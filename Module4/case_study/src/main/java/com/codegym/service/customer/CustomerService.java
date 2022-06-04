package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Page<Customer> listAllCustomer(Pageable pageable);
    void createCustomer(Customer customer);
    Customer getCustomerById(int id);
    void editCustomer(Customer customer);
    void deleteCustomerById(int id);
    Page<Customer> findCustomersByCustomerType_IdAndGenderIdAndNameContaining(int typeId,
                              int genderId, String name, Pageable pageable);

}
