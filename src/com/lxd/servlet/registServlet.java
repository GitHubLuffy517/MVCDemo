package com.lxd.servlet;

import com.lxd.bean.User;
import com.lxd.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registServlet")
public class registServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
//            Date日期转换要注册一个日期转换器
//            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.populate(user, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.userRegist(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.getSession().setAttribute("alregist", "该账号已被注册");
            response.sendRedirect("regist.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
