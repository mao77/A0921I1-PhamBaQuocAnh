package com.codegym.repository.service;

import com.codegym.entity.service.Service;
import com.codegym.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findServicesByServiceType_Name(String serviceTypeName,Pageable pageable);
    Page<Service> findServicesByCostBetween(Double cost1,Double cost2,Pageable pageable);
}
