package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.repository.impl.UserRepositoryImpl;
import model.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> listAll() {
       return userRepository.selectAllUsers();
    }

    @Override
    public boolean add(User user) {
            return userRepository.insertUser(user);
    }


    @Override
    public boolean delete(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public User select(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public boolean update(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortUserList();
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepository.searchList(country);
    }


}

