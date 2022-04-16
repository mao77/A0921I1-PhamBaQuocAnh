package model.service;

import model.bean.Service;

import java.util.List;

public interface ServiceService {
    List<Service> listAll();
    boolean add(Service service);
    List<Service> search(String name,String rentTypeId,String serviceTypeId);
    Service getById(int id);
    boolean update(Service service);
    boolean delete(int id);
}
