package com.onlineShop.dao;

import com.onlineShop.model.User;

import java.util.List;

/**
 * Created by Mingwei on 10/12/2018
 * Modified by Andres on 10/23/2018
 */
public interface UserDao {
    void editUser(User user);
    User getUserByUserId(int userId);
    void addUser(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
    User getUserByEmail(String username);
}
