package com.lxd.servlet;

import com.lxd.service.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String username = request.getParameter("username");
        if (userService.deleteUser(username)) {
//            从数据库删除后也要删除在线状态
            ServletContext sc=request.getServletContext();
            Map<String, HttpSession> userMap=(Map<String, HttpSession>)sc.getAttribute("userMap");
            userMap.remove(username);
            response.sendRedirect("showallUser.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
