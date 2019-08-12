<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/11
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/server/productSearch.css">
</head>
<body>
<%@include file="checkUser.jsp"%>
<div class="row">
    <div class="col-md-12 col-sm-12">
        <div class="table-responsive" id="productSearch">
            <form class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" id="keyWord" placeholder="输入名称关键字">
                    <div id="showSearch">
                        <table class="table table-hover">
                            <%-- 搜索框展示 --%>
                        </table>
                    </div>
                </div>
                <button type="button" class="btn btn-default" value="1" id="lookMore">查看更多</button>
                <button type="button" class="btn btn-warning" id="clearTab">清空表格</button>
            </form>
            <table class="table table-hover" id="searchTab">
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>标题</th>
                    <th>价格</th>
                    <th>状态</th>
                    <th>上架时间</th>
                    <th>更新时间</th>
                    <th>操作</th>
                </tr>
            </table>
            <button type="button" class="btn btn-default btn-sm">上一页</button>
            <button type="button" class="btn btn-default btn-sm">下一页</button>
        </div>
    </div>
</div>
</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/productSearch.js"></script>
</html>
