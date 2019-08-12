<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        try {
            String s = request.getSession().getAttribute("user").toString();
        }catch (Exception e){
    %>
    <script>
        alert("非法登录，无权访问！");
        // window.location.href = "http://localhost:8080";
        window.open("http://localhost:8080","_self");
    </script>
    <%  } %>
</body>
</html>
