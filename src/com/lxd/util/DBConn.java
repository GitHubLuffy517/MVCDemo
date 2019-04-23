package com.lxd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConn {
    private static String driver;
    private static String url;
    private static String name;
    private static String pass;
    private static Connection conn = null;

    //返回一个连接对象
    public static Connection init() {
        try {
//            初始化数据库，从配置文件中获取用户名与密码
            ResourceBundle rb = ResourceBundle.getBundle("db");
            driver = rb.getString("driver");
            url = rb.getString("url");
            name = rb.getString("name");
            pass = rb.getString("pass");
//            加载驱动，反射
            Class.forName(driver);
//            获取数据库链接
            conn = DriverManager.getConnection(url, name, pass);
            if (conn != null) {
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
