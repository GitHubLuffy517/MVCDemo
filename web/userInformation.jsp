<%@ page import="com.lxd.bean.User" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 目光
  Date: 2019/3/31
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <style>
        h3 {
            margin-left: 10px;
        }

        #a1 {
            margin-left: 88%;
            text-decoration: none;
            color: black;
        }

        #box {
            margin-top: 30px;
            margin-left: 3%;
            padding-top: 20px;
            width: 95%;
            height: 60px;
        }

        table {
            background-image: url("image/ironman.jpg");
            width: 100%;
            height: 100%;
        }

        body {
            background-image: url("image/ironman.jpg");
        }

        tr td {
            text-align: center;
        }

        input {
            width: 150px;
            height: 33px;
            border: 1px solid gainsboro;
        }

    </style>
    <script type="text/javascript" src="js/imput.js" charset="UTF-8"></script>
</head>
<body>
<%
    String username = (String) session.getAttribute("success");
    Map<String, HttpSession> userMap = (Map<String, HttpSession>) application.getAttribute("userMap");
    HttpSession userSession = userMap.get(username);
    User user = new User();
    if (userSession == null) {
        response.sendRedirect("login.jsp");
    } else {
        user = (User) userSession.getAttribute("user");
    }
%>

<div>
    <h3> 欢迎您：<%=user.getUsername()%><a href="logoutServlet?username=${username}" id="a1">退出</a></h3>
    <hr>
</div>
<div style="background-color: #FFE1A3 " id="box">
    <table>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>性别</td>
            <td>操作</td>
        </tr>
        <form name="updateForm" action="updateServlet?username=<%=username%>&id=user" method="post">
            <tr>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td><input name="age" class="input" value=<%=user.getAge()%>></td>
                <td><input name="sex" class="input" value=<%=user.getSex()%>></td>
                <td><input type="submit" value="更新" onclick="return Cmd()"></td>
            </tr>

        </form>

    </table>
</div>
</body>
</body>
</html>
