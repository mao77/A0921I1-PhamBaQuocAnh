package model.repository.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "abc@123";

    private static final String ADD_NEW=" insert into customer(customer_type_id,customer_name,customer_birthday, customer_gender,customer_id_card,customer_phone ,customer_email,customer_address) \n" +
            " values (?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER = "update customer set " +
            "customer_type_id = ?,customer_name = ?,customer_birthday = ?,customer_gender = ?," +
            "customer_id_card = ?,customer_phone = ?,customer_email= ?, customer_address =? " +
            "where customer_id = ?;";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String SEARCH ="SELECT * FROM customer where customer_name like ? and customer_email like ? and customer_type_id like ?;";

    @Override
    public List<Customer> selectAllCustomers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customerList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt(1);
                int typeID = rs.getInt(2);
                String name = rs.getString(3);
                String birthday = rs.getString(4);
                boolean gender = rs.getBoolean(5);
                String idCard = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customerList.add(new Customer(id, typeID, name, birthday, gender,idCard,phone,email,address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;       }

    @Override
    public boolean add(Customer customer) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setInt(1,customer.getTypeID());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setDate(3, Date.valueOf(customer.getBirthday()));
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
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
    public Customer getCustomerById(int id) {
//        List<User> userList = new ArrayList<>();
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                int typeId = rs.getInt(2);
                String name = rs.getString(3);
                String birthday = rs.getString(4);
                boolean gender = rs.getBoolean(5);
                String idCard = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customer = new Customer(id1,typeId,name,birthday,gender,idCard,phone,email,address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);) {
            statement.setInt(1, customer.getTypeID());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getBirthday());
            statement.setBoolean(4, customer.isGender());
            statement.setString(5, customer.getIdCard());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.setInt(9, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> searchCustomer(String searchName,String searchEmail,String searchTypeId) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+searchName+"%");
            preparedStatement.setString(2,"%"+searchEmail+"%");
            preparedStatement.setString(3,"%"+searchTypeId+"%");

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1); // colummLable : tên  thuocj tính của bảng
                int typeId = resultSet.getInt(2); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString(3);
                String birthday = resultSet.getString(4);
                Boolean gender = resultSet.getBoolean(5);
                String idCard = resultSet.getString(6);
                String phone = resultSet.getString(7);
                String email = resultSet.getString(8);
                String address = resultSet.getString(9);
                Customer customer = new Customer(id,typeId,name,birthday,gender,idCard,phone,email,address);
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
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
