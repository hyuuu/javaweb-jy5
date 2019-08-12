<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/11
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/server/productUpload.css">
</head>
<body>
<%@include file="checkUser.jsp"%>
<div class="row">
    <div class="col-md-12 col-sm-12" id="upload">
        <form action="#" method="post" enctype="multipart/form-data" id="uploadForm">
            <div class="form-group">
                <div class="dropdown">
                    <button class="btn btn-default" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        选择商品
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="">1</a></li>
                        <li><a href="">1</a></li>
                        <li><a href="">1</a></li>
                        <li><a href="">1</a></li>
                        <li><a href="">1</a></li>
                    </ul>
                </div>
            </div>
            <div class="form-group">
                <button class="btn btn-default" type="button" id="selectBtn">
                    <i class="glyphicon glyphicon-folder-open"></i>
                    选择图片
                </button>
                <input type="file" id="uploadInput">
            </div>
            <div class="form-group">
                <input type="text" id="testText" class="form-control">
            </div>
            <div class="form-group">
                <img src="" id="imgShow">
            </div>
            <div class="form-group">
                <button class="btn btn-success" type="button" id="uploadBtn">
                    <i class="glyphicon glyphicon-cloud-upload"></i>
                    开始上传
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/productUpload.js"></script>
</html>
