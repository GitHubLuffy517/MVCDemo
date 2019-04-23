<%-- Created by IntelliJ IDEA. --%>
<%--错误界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
  <head>
    <title></title>
    <style>
      body{
        background-image: url("image/ironman.jpg");
      }
    </style>
  </head>
  <body>
<%
response.sendRedirect("login.jsp");
%>
  </body>
</html>