<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/11
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/server/productAdd.css">
</head>
<body>
<%@include file="checkUser.jsp"%>

<div class="row">
    <div class="col-md-12 col-sm-12">
        <div class="table-responsive" id="productAdd">
            <form action="#" id="productAddForm" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>名称</label>
                    <input type="text" name="addName" class="form-control" placeholder="请输入商品名称">
                </div>
                <div class="form-group">
                    <label>分类</label>
                    <input type="number" name="addCategoryId" class="form-control" placeholder="请选择分类">
                </div>
                <div class="form-group">
                    <label>标题</label>
                    <input type="text" name="addSubtitle" class="form-control" placeholder="请选择分类">
                </div>
                <div class="form-group">
                    <label>详细</label>
                    <textarea class="form-control" name="addDetail" placeholder="请输入详细介绍"></textarea>
                </div>
                <div class="form-group">
                    <label>价格</label>
                    <input type="text" name="addPrice" class="form-control" placeholder="请输入金额">
                </div>
                <div class="form-group">
                    <label>状态</label>
                    <input type="number" name="addStatus" class="form-control" placeholder="请选择状态">
                </div>
                <div class="form-group">
                    <label>主题图片</label>
                    <input type="file" name="addMainImage">
                </div>
                <button type="button" id="addSubmit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/productAdd.js"></script>
</html>
