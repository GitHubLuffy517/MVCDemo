<%@ page import="com.lxd.service.UserServiceImpl" %>
<%@ page import="com.lxd.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 目光
  Date: 2019/3/28
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="index.jsp" %>--%>
<html>
<head>
    <title>所有用户</title>
    <style>
        h3 {
            margin-left: 10px;
        }

        #a1 {
            margin-left: 85%;
        }

        a {
            text-decoration: none;
            color: black;
        }

        .d {
            margin-top: 30px;

            padding-top: 20px;
            width: 85%;
        }


        table {
            background-image: url("image/ironman.jpg");
            width: 100%;
        }

        #title {
            color: burlywood;
            margin-left: 50px;
        }

        body {
            background-image: url("image/ironman.jpg");
        }

        .tr1 {
            width: 100%;
            height: 15px;
        }

        .tr1 td {
            text-align: center;
        }

        input {
            width: 150px;
            height: 33px;
            border: 1px solid gainsboro;

        }

        #update {
            background-color: #FDAB73;
        }

        button {
            width: 150px;
            height: 33px;
            border: 1px solid gainsboro;
            background-color: #FDAB73;
        }

        .input {
            width: 25px;
            text-align: center;
        }

        #online {
            width: 60px;
        }
    </style>
    <script type="text/javascript" src="js/imput.js" charset="UTF-8"></script>
</head>
<body>
<div style="background-color: white">
    <h3><b id="title">Iron men</b><a href="logoutServlet" id="a1">退出</a></h3>
</div>

<%
    //    获取数据库中的所有用户
    UserServiceImpl userService = new UserServiceImpl();
    List<User> list = userService.getAllUser();
//    获取在线用户
    Map<String, HttpSession> userMap = (Map<String, HttpSession>) application.getAttribute("userMap");
    String username = (String) session.getAttribute("admin");
//    如果用户不在线，就让其登陆
    if (username == null) {
        response.sendRedirect("adminLogin.jsp");
    }
%>

<div class="d" id="box">
    <table>
        <tr><h3 align="center">所有用户</h3></tr>
        <tr class="tr1">
            <td>序号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>性别</td>
            <td>状态</td>
            <td>用户ip地址</td>
            <td>登陆时间</td>
            <td>操作</td>
        </tr>
        <%
            int i = 0;
            for (User user : list) {
                i++;
        %>
        <form name="updateForm" action="updateServlet?username=<%=user.getUsername()%>&id=admin" method="post">
            <tr class="tr1">
                <td><%=i%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td><input name="age" value="<%=user.getAge()%>" class="input"></td>
                <td><input name="sex" value="<%=user.getSex()%>" class="input"></td>
                <td>
                    <button id="online"><%=userMap.containsKey(user.getUsername()) == true ? "在线" : " 离线"%>
                    </button>
                </td>
                <td>
                    <%
                        String ips[];
                        Object ips1[];
                        HttpSession ipSession = userMap.get(user.getUsername());
                        if (ipSession != null) {
                            String ip = (String) ipSession.getAttribute("ip");
                            ips = ip.split(",");
//                            去掉ip数组中的重复ip
                            List iplist = new ArrayList();
                            for (String s : ips
                            ) {
                                if (!iplist.contains(s)) {
                                    iplist.add(s);
                                }
                            }
//                            toArray方法转换为数组
                            ips1 = iplist.toArray();
                        } else {
                            ips1 = null;
                        }
                    %>
                    <%
                        if (ips1 == null) {
                    %>
                    <%=" "%>
                    <%
                    } else {
                        for (Object s : ips1) {
                    %>
                    <b><%=s%>
                    </b><br>
                    <%
                            }
                        }
                    %>
                </td>
                <td><%
                    //获取session创建的时间
                    String date = "";
                    HttpSession dateSession = userMap.get(user.getUsername());
                    if (dateSession != null) {
                        Date time = new Date(dateSession.getCreationTime());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        date = sdf.format(time);
                    }
                %>
                    <%=date%>
                </td>
                <td>
                    <button><a href="deleteServlet?username=<%=user.getUsername()%>">删除</a></button>&nbsp;&nbsp;<input
                        type="submit" value="更新" id="update" onclick="return Cmd()">&nbsp;&nbsp;<button><a
                        href="letoutServlet?username=<%=user.getUsername()%>">踢出去</a>
                </button>
                </td>

            </tr>
        </form>
        <%

            }
        %>
    </table>
</div>

</body>
</html>
