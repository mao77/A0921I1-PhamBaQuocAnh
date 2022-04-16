package model.repository.impl;

import model.bean.EducationDegree;
import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.EducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    private static final String FIND_BY_ALL ="select * from education_degree ;";
    @Override
    public List<EducationDegree > listAll() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                EducationDegree educationDegree = new EducationDegree(id,name);
                educationDegreeList.add(educationDegree);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
