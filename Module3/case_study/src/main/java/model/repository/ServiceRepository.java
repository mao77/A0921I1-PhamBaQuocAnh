package model.repository;

import model.bean.Customer;
import model.bean.CustomerType;
import model.bean.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> listAll();
    boolean add(Service service);
    List<Service> search(String name,String rentTypeId,String serviceTypeId);
    Service getServiceById(int id);
    boolean updateService(Service service);
    boolean deleteService(int id);
}
