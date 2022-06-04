package com.codegym.service.service;

import com.codegym.entity.service.Service;
import com.codegym.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> listService(Pageable pageable);
    Service getServiceById(int id);
    void createService(Service service);
    void editService(Service service);
    void deleteServiceById(int id);
    Page<Service> findServicesByServiceType_Name(String serviceTypeName,Pageable pageable);
    Page<Service> findServicesByCostBetween(Double cost1,Double cost2,Pageable pageable);
}
