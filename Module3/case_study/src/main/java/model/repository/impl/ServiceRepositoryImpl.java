package model.repository.impl;

import model.bean.Customer;
import model.bean.Service;
import model.bean.ServiceType;
import model.repository.BaseRepository;
import model.repository.ServiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String ADD_NEW="insert into service (service_name,service_area,service_cost,service_max_people,rent_type_id" +
            ",service_type_id,standard_room,description_othe_convenience,pool_area,number_of_floors)"+
            " values (?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ALL ="select * from service;";
    private static final String SEARCH ="select * from service where service_name like ? and rent_type_id like ? and service_type_id like ?;";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id = ?";
    private static final String UPDATE_SERVICE = "update service set service_name = ?, service_area = ?," +
            "service_cost = ?, service_max_people = ?, rent_type_id = ?," +
            "service_type_id = ?, standard_room = ?, description_othe_convenience = ?," +
            "pool_area = ?, number_of_floors = ? where  service_id = ?;";
    private static final String DELETE_SERVICE = "delete from service where service_id = ?;";

    @Override
    public List<Service> listAll() {
            List<Service> serviceList = new ArrayList<>();
            Connection connection = BaseRepository.getConnect();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
                ResultSet resultSet =preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                    String name  = resultSet.getString(2);
                    int area  = resultSet.getInt(3);
                    double cost  = resultSet.getDouble(4);
                    int maxPeople  = resultSet.getInt(5);
                    int rentTypeId  = resultSet.getInt(6);
                    int typeId  = resultSet.getInt(7);
                    String standardRoom  = resultSet.getString(8);
                    String descriptionOtherConvenience  = resultSet.getString(9);
                    int poolArea  = resultSet.getInt(10);
                    int numberOfFloors  = resultSet.getInt(11);
                    Service service = new Service(id,name,area,cost,maxPeople,rentTypeId,typeId,standardRoom
                            ,descriptionOtherConvenience,poolArea,numberOfFloors);
                    serviceList.add(service);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return serviceList;
        }

    @Override
    public boolean add(Service service) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getArea());
            preparedStatement.setDouble(3,service.getCost() );
            preparedStatement.setInt(4,service.getMaxPeople());
            preparedStatement.setInt(5,service.getRentTypeId());
            preparedStatement.setInt(6,service.getTypeId());
            preparedStatement.setString(7,service.getStandardRoom());
            preparedStatement.setString(8,service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9,service.getPoolArea());
            preparedStatement.setInt(10,service.getNumberOfFloors());
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Service> search(String searchName,String searchRentTypeId, String searchServiceTypeId){
        List<Service> serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setString(2, "%" + searchRentTypeId + "%");
            preparedStatement.setString(3, "%" + searchServiceTypeId + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name = resultSet.getString(2); // colummLable : tên  thuocj tính của bảng
                int area = resultSet.getInt(3);
                double cost = resultSet.getDouble(4);
                int maxPeople = resultSet.getInt(5);
                int rentTypeId = resultSet.getInt(6);
                int serviceTypeId = resultSet.getInt(7);
                String standardRoom = resultSet.getString(8);
                String descriptionOtherConvenience = resultSet.getString(9);
                double poolArea = resultSet.getDouble(10);
                int numberOfFloors = resultSet.getInt(11);
                Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId,
                        standardRoom, descriptionOtherConvenience, poolArea,numberOfFloors);
                serviceList.add(service);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Service getServiceById(int id) {
        Service service = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                String name = rs.getString(2);
                int area = rs.getInt(3);
                double cost = rs.getDouble(4);
                int maxPeoPle = rs.getInt(5);
                int rentTypeId = rs.getInt(6);
                int serviceTypeId = rs.getInt(7);
                String standardRoom = rs.getString(8);
                String descriptionOtherConvenience = rs.getString(9);
                double poolArea = rs.getDouble(10);
                int numberOfFloors = rs.getInt(11);
                service = new Service(id1,name,area,cost,maxPeoPle,rentTypeId,serviceTypeId,
                        standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return service;
    }

    @Override
    public boolean updateService(Service service) {
        boolean rowUpdated = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE);) {
            statement.setString(1, service.getName());
            statement.setInt(2, service.getArea());
            statement.setDouble(3, service.getCost());
            statement.setInt(4, service.getMaxPeople());
            statement.setInt(5, service.getRentTypeId());
            statement.setInt(6, service.getTypeId());
            statement.setString(7, service.getStandardRoom());
            statement.setString(8, service.getDescriptionOtherConvenience());
            statement.setDouble(9, service.getPoolArea());
            statement.setInt(10, service.getNumberOfFloors());
            statement.setInt(11, service.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteService(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

