package com.lxd.dao;

import com.lxd.bean.User;

import java.util.List;

public interface userDao {
    User userLogin(String username, String password);
    boolean userRegist(User user);
    List<User> getAllUser();
    boolean deleteUser(String username);
    boolean updateUser(int age, String sex, String username);

}
