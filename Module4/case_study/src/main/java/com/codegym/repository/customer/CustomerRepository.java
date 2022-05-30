package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findCustomersByNameContainingAndGender_Id(String searchName, int id, Pageable pageable);
}
