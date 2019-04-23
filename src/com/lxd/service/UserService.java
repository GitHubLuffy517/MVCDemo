package com.lxd.service;

import com.lxd.bean.User;

import java.util.List;

public interface UserService {
    User userLogin(String username, String password);

    boolean userRegist(User user);

    List<User> getAllUser();

    boolean deleteUser(String username);

    boolean updateUser(int age, String sex, String username);
}
