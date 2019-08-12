<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../../bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../layui-icon/css/layui-icon.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
</head>
<body>
    <%@include file="checkUser.jsp"%>
    <%@include file="common.jsp" %>

    <div class="container context">



    </div>

</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/home.js"></script>
</html>
