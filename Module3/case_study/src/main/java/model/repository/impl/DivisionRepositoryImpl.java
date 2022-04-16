package model.repository.impl;

import model.bean.Division;
import model.bean.EducationDegree;
import model.repository.BaseRepository;
import model.repository.DivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements DivisionRepository {
    private static final String FIND_BY_ALL ="select * from division ;";
    @Override
    public List<Division> listAll() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                Division division = new Division(id,name);
                divisionList.add(division);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
