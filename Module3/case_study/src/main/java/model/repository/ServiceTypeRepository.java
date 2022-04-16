package model.repository;

import model.bean.CustomerType;
import model.bean.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    List<ServiceType> findAll();
}
