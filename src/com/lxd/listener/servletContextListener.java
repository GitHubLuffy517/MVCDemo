package com.lxd.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//当服务器启动时创建ServletContext对象，初始化时新建一个Map，用来存放在线用户
public class servletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc=sce.getServletContext();
        Map<String, HttpSession> userMap=new HashMap<>();
        sc.setAttribute("userMap",userMap);
    }
}
