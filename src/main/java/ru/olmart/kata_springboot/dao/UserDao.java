package ru.olmart.kata_springboot.dao;

import ru.olmart.kata_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
    void add(User user);
    void update(Long id, User newUser);
    void delete(long id);
}
