<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>common</title>
    <link rel="stylesheet" type="text/css" href="../../css/server/common.css"/>
</head>
<body>

<%@include file="checkUser.jsp"%>


<!-- 顶部导航 -->
<div class="container">
    <div class="row Top-nav">
        <!-- 上左 -->
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 T-left">
            <div>LOGO</div>
            <i id="activeMenu" class="layui-icon">&#xe66b;</i>
        </div>
        <!-- 上右 -->
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 T-right">
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 text-right">
                <div id="adminName">
                    管理员<i class="layui-icon">&#xe625;</i>
                    <dl class="text-center">
                        <dd>基本资料</dd>
                        <dd>修改密码</dd>
                        <hr >
                        <dd>退出登录</dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 左边菜单 -->
<div class="container Left-nav">
    <div class="row">
        <div class="col-sm-12 col-xs-12 logo">
            <div>LOGO</div>
        </div>
        <div class="col-sm-12 col-xs-12 L-nav-list">
            <div class="L-show">
                <i class="fa fa-user-o i-left"></i>
                用户管理
                <i class="fa fa-caret-down i-right"></i>
            </div>
            <div class="L-hidden">
                <ul>
                    <li id="userList">用户列表</li>
                    <li>禁用管理员</li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-xs-12 L-nav-list">
            <div class="L-show">
                <i class="fa fa-shopping-cart i-left"></i>
                商品管理
                <i class="fa fa-caret-down i-right"></i>
            </div>
            <div class="L-hidden">
                <ul>
                    <li id="productList">商品列表</li>
                    <li id="productSearch">商品搜索</li>
                    <li id="productAdd">增加商品</li>
                    <li>修改商品</li>
                    <li>商品下架</li>
                    <li>商品详情</li>
                    <li id="productUpload">图片上传</li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-xs-12 L-nav-list">
            <div class="L-show">
                <i class="fa fa-reorder i-left"></i>
                订单列表
                <i class="fa fa-caret-down i-right"></i>
            </div>
            <div class="L-hidden">
                <ul>
                    <li id="orderList">订单列表</li>
                    <li>订单查询</li>
                    <li>订单详情</li>
                    <li>修改订单</li>
                </ul>
            </div>
        </div>
        <div class="col-sm-12 col-xs-12 L-nav-list">
            <div class="L-show">
                <i class="fa fa-tags i-left"></i>
                分类列表
                <i class="fa fa-caret-down i-right"></i>
            </div>
            <div class="L-hidden">
                <ul>
                    <li>分类列表</li>
                    <li>增加分类</li>
                    <li>修改分类</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../js/server/common.js" type="text/javascript" charset="utf-8"></script>
</html>
