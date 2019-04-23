package com.lxd.bean;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;
//设置绑定Bean的监听器，当session绑定bean时触发，不用配置
public class User implements HttpSessionBindingListener {
    private String username;
    private String password;
    private int age;
    private String sex;

    public User() {
    }

    public User(String username, String password, int age, String sex) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
//        session绑定bean时获取servletContext对象
        ServletContext sc=event.getSession().getServletContext();
        Map<String,HttpSession> userMap=( Map<String,HttpSession> )sc.getAttribute("userMap");
//        在map中放置当前session,获取到的是地址，不用再添加到ServletContext的域中
        userMap.put(username,event.getSession());
    }
}
