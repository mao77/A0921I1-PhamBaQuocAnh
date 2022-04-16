package model.repository.impl;

import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.RentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    private static final String FIND_BY_ALL ="select * from rent_type;";
    @Override
    public List<RentType> listAll() {
            List<RentType> rentTypeList = new ArrayList<>();
            Connection connection = BaseRepository.getConnect();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
                ResultSet resultSet =preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                    String name  = resultSet.getString(2);
                    RentType rentType = new RentType(id,name);
                    rentTypeList.add(rentType);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return rentTypeList;
        }
    }

