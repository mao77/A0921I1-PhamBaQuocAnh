package model.service;

import model.bean.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    boolean add(User user);
    boolean delete(int id);
    User select(int id);
    boolean update(User user);
    List<User> sortByName();
    List<User> searchByCountry(String country);
    User getUserById(int id);
    void insertUserStore(User user);
}
