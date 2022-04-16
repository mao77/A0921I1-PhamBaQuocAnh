package model.service.impl;

import model.bean.ServiceType;
import model.repository.ServiceTypeRepository;
import model.repository.impl.ServiceTypeRepositoryImpl;
import model.service.ServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
    public List<ServiceType> listAll() {
        return serviceTypeRepository.findAll();
    }
}
