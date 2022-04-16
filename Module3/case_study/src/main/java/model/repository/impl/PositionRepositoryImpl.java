package model.repository.impl;

import model.bean.Position;
import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.PositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private static final String FIND_BY_ALL ="select * from position ;";
    @Override
    public List<Position> listAll() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                Position position = new Position(id,name);
                positionList.add(position);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
