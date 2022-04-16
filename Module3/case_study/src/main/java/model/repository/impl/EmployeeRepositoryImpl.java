package model.repository.impl;

import model.bean.Employee;
import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String ADD_NEW="insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone," +
            "employee_email,employee_address,position_id,education_degree_id" +
            ",division_id)"+
            " values (?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ALL ="select * from employee;";
    private static final String SEARCH ="select * from employee where employee_name like ? and position_id like ? and education_degree_id like ? and division_id like ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?," +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?," +
            "employee_email = ?, employee_address = ?, position_id = ?," +
            "education_degree_id = ?, division_id = ? where  employee_id = ?;";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    @Override
    public List<Employee> listAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(2);
                String birthday  = resultSet.getString(3);
                String idCard  = resultSet.getString(4);
                double salary  = resultSet.getDouble(5);
                String phone  = resultSet.getString(6);
                String email  = resultSet.getString(7);
                String address  = resultSet.getString(8);
                int positionId  = resultSet.getInt(9);
                int educationDegreeId  = resultSet.getInt(10);
                int divisionId  = resultSet.getInt(11);
                Employee employee = new Employee(id,name,birthday,idCard,salary,phone,email,
                        address,positionId,educationDegreeId,divisionId);
                employeeList.add(employee);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard() );
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivisionId());
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
    public List<Employee> search(String searchName, String searchPositionId, String searchEducationDegreeId, String searchDivisionId) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setString(2, "%" + searchPositionId + "%");
            preparedStatement.setString(3, "%" + searchEducationDegreeId + "%");
            preparedStatement.setString(4, "%" + searchDivisionId + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                String name = resultSet.getString(2); // colummLable : tên  thuocj tính của bảng
                String birthday = resultSet.getString(3);
                String idCard = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);
                int positionId = resultSet.getInt(9);
                int educationDegreeId = resultSet.getInt(10);
                int divisionId = resultSet.getInt(11);
                Employee employee = new Employee(id, name, birthday, idCard, salary,
                        phone, email, address, positionId, educationDegreeId,divisionId);
                employeeList.add(employee);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = rs.getString(3);
                String idCard = rs.getString(4);
                double salary = rs.getDouble(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String address = rs.getString(8);
                int positionId = rs.getInt(9);
                int educationDegreeId = rs.getInt(10);
                int divisionId = rs.getInt(11);
                employee = new Employee(id1,name,birthday,idCard,salary,phone,email,
                        address,positionId,educationDegreeId,divisionId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        boolean rowUpdated = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getBirthday());
            statement.setString(3, employee.getIdCard());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhone());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());
            statement.setInt(11, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);) {
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
