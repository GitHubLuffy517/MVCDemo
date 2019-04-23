package com.lxd.dao;

import com.lxd.bean.User;
import com.lxd.util.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {
    private static ResultSet rs = null;
    private static PreparedStatement stmt = null;

    @Override
    public User userLogin(String username, String password) {
        String sql = "select * from user_test where username=? and password=?";
        try {
//            使用prepareStatement预制对象可以避免sql注入
            stmt = DBConn.init().prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
//            获取一个结果集
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    User user = new User(rs.getString("username"), rs.getString("password"),
                            rs.getInt("age"), rs.getString("sex"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                DBConn.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean userRegist(User user) {
        String sql = "insert into user_test(username,password,age,sex) values(?,?,?,?)";
        try {
            stmt = DBConn.init().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getAge());
            stmt.setString(4, user.getSex());
            int i = stmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                DBConn.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
//        用一个User泛型的List来存放所有的User对象
        List<User> userlist = new ArrayList<>();
        String sql = "select * from user_test";
        try {
            stmt = DBConn.init().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                userlist.add(user);
            }
            return userlist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                DBConn.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(String username) {
        String sql = "delete from user_test where username=?";
        try {
            stmt = DBConn.init().prepareStatement(sql);
            stmt.setString(1, username);
            int i = stmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                DBConn.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(int age, String sex, String username) {
        String sql = "update user_test set age=?,sex=? where username=?";
        try {
            stmt = DBConn.init().prepareStatement(sql);
            stmt.setInt(1, age);
            stmt.setString(2, sex);
            stmt.setString(3, username);
            int i = stmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                DBConn.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    private static void close() {
        try {
            rs.close();
            stmt.close();
            DBConn.closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
