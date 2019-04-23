<%--
  Created by IntelliJ IDEA.
  User: 目光
  Date: 2019/3/28
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="index.jsp" %>
<html>
<head>
    <title>欢迎注册</title>
    <style>
        div {
            width: 500px;
            height: 250px;
            margin-top: 200px;
            margin-left: 30%;
            padding-top: 20px;
            background-image: url("image/ironman.jpg");
        }

        table {
            margin-left: 25px;
        }

        body {
            background-image: url("image/ironman.jpg");
        }

        input {
            width: 200px;
            height: 33px;
            border: 1px solid gainsboro;
            padding-left: 7px;
        }

        .button {
            margin-top: 20px;
        .
        }
    </style>
    <script type="text/javascript" src="js/imput.js" charset="UTF-8"></script>
</head>
<body>
<div style="background-color: burlywood" id="box">
    <form action="registServlet" name="registForm" method="post">
        <table>
            <tr>
                <td>请输入账号：</td>
                <td><input name="username" type="text" class="input"></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input name="password" type="password" class="input"></td>
            </tr>
            <tr>
                <td>请输入年龄：</td>
                <td><input name="age" type="text" class="input"></td>
            </tr>
            <tr>
                <td>请输入性别：</td>
                <td><input name="sex" type="text" class="input"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input class="button" type="submit" value="注册" onclick="return Cmd()">&nbsp;&nbsp;&nbsp;&nbsp;<input
                        class="button" type="reset"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">${alregist}</td>
            </tr>
        </table>
    </form>
    <%
        session.setAttribute("alregist", null);
    %>
</div>

</body>
</html>
