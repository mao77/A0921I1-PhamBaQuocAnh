package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAll();
    boolean add(Customer customer);
    Customer getById(int id);
    boolean updadate(Customer customer);
    boolean delete(int id);
    List<Customer> search(String name,String email,String typeId);
}
