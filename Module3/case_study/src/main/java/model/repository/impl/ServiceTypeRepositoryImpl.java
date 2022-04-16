package model.repository.impl;

import model.bean.CustomerType;
import model.bean.ServiceType;
import model.repository.BaseRepository;
import model.repository.ServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private static final String FIND_BY_ALL ="select * from service_type;";
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                ServiceType serviceType = new ServiceType(id,name);
                serviceTypeList.add(serviceType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }
}
