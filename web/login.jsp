<%--
  Created by IntelliJ IDEA.
  User: 目光
  Date: 2019/3/28
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="index.jsp" %>
<html>
<head>
    <title>欢迎登陆</title>
    <style>
        div {
            margin-top: 200px;
            margin-left: 40%;
            padding-top: 40px;
            width: 330px;
            height: 200px;
            background-image: url("image/ironman.jpg");
        }

        table {
            margin-left: 25px;
        }

        #failure {
            color: darkred;
        }

        a {
            text-decoration: none;
        }

        body {
            background-image: url("image/ironman.jpg");
        }

        .btn {
            width: 62px;
            height: 30px;
            border-radius: 5px;
            background-image: url("image/ironman.jpg");
            margin-top: 8px;
            margin-bottom: 7px;
        }

        input {
            width: 200px;
            height: 33px;
            border: 1px solid gainsboro;
            padding-left: 7px;
        }

        #in1 {
            margin-left: 15px;
        }

    </style>
    <script type="text/javascript" src="js/imput.js"  charset="UTF-8"></script>
</head>
<body>
<div style="background-color: #FF6F10" id="box">
    <form action="loginServlet" name="loginForm" method="post">
        <table>
            <tr>
                <td><b>账&nbsp;&nbsp;&nbsp;&nbsp;号：</b></td>
                <td><input type="text" name="username" class="input"></td>
            </tr>
            <tr>
                <td><b>密&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
                <td><input type="password" name="password" class="input"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input class="btn" type="submit" value="登陆" id="in1" onclick="return Cmd()">&nbsp;&nbsp;&nbsp;&nbsp;<input
                        class="btn" type="reset"></td>
            </tr>
            <tr align="center">
                <td colspan="2">还没有账号？<a href="regist.jsp">点击注册</a></td>
            </tr>
            <tr align="center">
                <td colspan="2"><p id="failure">${failure}</p></td>
            </tr>
            <tr align="center">
                <td colspan="2"><a href="adminLogin.jsp">管理员登陆</a></td>
            </tr>
        </table>
    </form>
    <%
        session.setAttribute("failure", null);
    %>
</div>
</body>
</html>
