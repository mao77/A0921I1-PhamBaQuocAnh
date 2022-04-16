package model.repository.impl;

import model.bean.CustomerType;
import model.repository.BaseRepository;
import model.repository.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
//    private static List<CustomerType> customerTypeList = new ArrayList<>();
    private static final String FIND_BY_ALL ="select * from customer_type;";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                CustomerType customerType = new CustomerType(id,name);
                customerTypeList.add(customerType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
