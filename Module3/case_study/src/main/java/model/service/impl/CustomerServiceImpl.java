package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> listAll() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public boolean updadate(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> search(String name,String email,String typeId) {
        return customerRepository.searchCustomer(name,email,typeId);
    }

}
