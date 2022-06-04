package com.codegym.service.service;

import com.codegym.entity.service.ServiceType;
import com.codegym.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.codegym.entity.service.Service> listService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.codegym.entity.service.Service getServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void createService(com.codegym.entity.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void editService(com.codegym.entity.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteServiceById(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<com.codegym.entity.service.Service> findServicesByServiceType_Name(String serviceTypeName, Pageable pageable) {
        return serviceRepository.findServicesByServiceType_Name(serviceTypeName,pageable);
    }

    @Override
    public Page<com.codegym.entity.service.Service> findServicesByCostBetween(Double cost1, Double cost2, Pageable pageable) {
        return serviceRepository.findServicesByCostBetween(cost1,cost2,pageable);
    }

}
