package com.lxd.servlet;

import com.lxd.bean.User;
import com.lxd.service.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ServletContext sc = request.getServletContext();
//        登陆时从Map中获取当前用户的session
        Map<String, HttpSession> userMap = (Map<String, HttpSession>) sc.getAttribute("userMap");
        HttpSession ipSession = userMap.get(username);
        String ip;
//        如果获取到了，说明是在线状态，把ip存放至字符串内
        if (ipSession != null) {
            ip = (String) ipSession.getAttribute("ip");
            ip += request.getRemoteAddr();
        } else {
//            字符串中的IP地址用逗号隔开
            ip = request.getRemoteAddr() + ",";
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.userLogin(username, password);
        if (user != null) {
            request.getSession().setAttribute("ip", ip);
//            触发绑定bean监听器，会把当前session存入ServletContext
            request.getSession().setAttribute("user", user);
//            用户返回给登陆成功界面的用户名
            request.getSession().setAttribute("success", username);
            response.sendRedirect("userInformation.jsp");
        } else {
//            如果登陆失败，重定向至登陆界面，返回失败信息
            request.getSession().setAttribute("failure", "用户名或密码错误！");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
