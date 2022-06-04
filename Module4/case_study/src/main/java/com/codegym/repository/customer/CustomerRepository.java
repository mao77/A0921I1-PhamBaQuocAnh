package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findCustomersByCustomerType_IdAndGenderIdAndNameContaining(int typeId,
                                int genderId, String name, Pageable pageable);
}
