package com.lxd.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc=request.getServletContext();
//        从在线用户列表中删除当前用户
        Map<String, HttpSession> userMap=(Map<String, HttpSession>)sc.getAttribute("userMap");
        userMap.remove(request.getSession().getAttribute("success"));
        sc.setAttribute("userMap",userMap);
        response.sendRedirect("login.jsp");
    }
}
