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
import java.util.Map;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        int ageInt = Integer.parseInt(age);
        UserServiceImpl userService = new UserServiceImpl();
        ServletContext sc = request.getServletContext();
        Map<String, HttpSession> userMap = (Map<String, HttpSession>) sc.getAttribute("userMap");
        HttpSession userSession = userMap.get(username);
        User user = (User) userSession.getAttribute("user");
//        如果是用户提交的修改
        if (request.getParameter("id").equals("user")){
//            如果用户在线
            if (userSession != null) {
//                修改用户信息
                if (userService.updateUser(ageInt, sex, username)) {
//                    将修改后的的user信息存放到userMap中
                    user.setSex(sex);
                    user.setAge(ageInt);
                    userSession.setAttribute("user", user);
                } else {
                    response.sendRedirect("index.jsp");
                }
//                不在线就重定向至登陆界面
            } else {
                response.sendRedirect("login.jsp");
            }
            response.sendRedirect("userInformation.jsp");
        }else {
            userService.updateUser(ageInt, sex, username);
            user.setSex(sex);
            user.setAge(ageInt);
            userSession.setAttribute("user", user);
            response.sendRedirect("showallUser.jsp");
        }




        }
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }
    }

