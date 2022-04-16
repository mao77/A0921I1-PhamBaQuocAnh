package model.repository;

import model.bean.User;

import java.util.List;

public interface UserRepository {
    public boolean insertUser(User user);

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id);

    public boolean updateUser(User user);
    public List<User> sortUserList();
    public List<User> searchList(String country);
    User getUserById(int id);
    void insertUserStore(User user);
}
