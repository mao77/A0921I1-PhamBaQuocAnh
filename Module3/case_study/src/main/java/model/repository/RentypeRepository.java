package model.repository;

import model.bean.CustomerType;
import model.bean.RentType;

import java.util.List;

public interface RentypeRepository {
    List<RentType> findAll();
}
