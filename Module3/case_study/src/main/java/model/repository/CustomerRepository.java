package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAllCustomers();
    boolean add(Customer customer);
    Customer getCustomerById(int id);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> searchCustomer(String name,String email,String typeId);
}
