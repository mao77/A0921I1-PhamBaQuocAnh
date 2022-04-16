package model.repository;

import model.bean.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> findAll();
}
