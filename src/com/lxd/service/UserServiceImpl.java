package com.lxd.service;

import com.lxd.bean.User;
import com.lxd.dao.userDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    userDaoImpl userdao = new userDaoImpl();

    @Override
    public User userLogin(String username, String password) {
        return userdao.userLogin(username, password);
    }

    @Override
    public boolean userRegist(User user) {
        return userdao.userRegist(user);
    }

    @Override
    public List<User> getAllUser() {
        return userdao.getAllUser();
    }

    @Override
    public boolean deleteUser(String username) {
        return userdao.deleteUser(username);
    }

    @Override
    public boolean updateUser(int age, String sex, String username) {
        return userdao.updateUser(age, sex, username);
    }
}
