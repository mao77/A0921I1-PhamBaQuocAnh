package model.service.impl;

import model.bean.RentType;
import model.repository.RentTypeRepository;
import model.repository.impl.RentTypeRepositoryImpl;
import model.service.RentypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> listAll() {
        return rentTypeRepository.listAll();
    }
}
