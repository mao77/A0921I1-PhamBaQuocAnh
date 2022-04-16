package model.service.impl;

import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;
import model.repository.impl.CustomerTypeRepositoryImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService  {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> listAll() {
        return customerTypeRepository.findAll();
    }
}
