package model.service.impl;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> listAll() {
        return serviceRepository.listAll();
    }

    @Override
    public boolean add(Service service) {
        return serviceRepository.add(service);
    }

    @Override
    public List<Service> search(String name, String rentTypeId, String serviceTypeId) {
        return serviceRepository.search(name,rentTypeId,serviceTypeId);
    }

    @Override
    public Service getById(int id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public boolean update(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public boolean delete(int id) {
        return serviceRepository.deleteService(id);
    }


}
