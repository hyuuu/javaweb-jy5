<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/server/userList.css"/>
</head>
<body>
<%@include file="checkUser.jsp"%>

<div class="row">
    <div class="col-md-12 col-sm-12">
        <div class="table-responsive">
            <table class="table table-hover" id="dataTable">
                <%--<tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>标题</th>
                    <th>价格</th>
                    <th>状态</th>
                    <th>上架时间</th>
                    <th>更新时间</th>
                    <th>更新时间</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>admin</td>
                    <td></td>
                    <td></td>
                    <td>管理员</td>
                    <td>正常</td>
                    <td>1565003869000</td>
                    <td>1565003869000</td>
                    <td>
                        <button class="btn btn-default btn-xs" type="button">编辑</button>
                        <button class="btn btn-danger btn-xs" type="button">禁用</button>
                    </td>
                </tr>--%>
            </table>
            <button type="button" class="btn btn-default btn-sm">上一页</button>
            <button type="button" class="btn btn-default btn-sm">下一页</button>
        </div>
    </div>
</div>

<%-- 编辑模态框 --%>
<div class="modal fade bs-example-modal-lg" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">商品编辑</h4>
            </div>
            <div class="modal-body">

                <%-- 编辑表单开始 --%>
                <form>
                    <div class="form-group">
                        <label>名称</label>
                        <input type="text" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label>分类</label>
                        <input type="text" class="form-control" id="categoryId">
                    </div>
                    <div class="form-group">
                        <label>标题</label>
                        <input type="text" class="form-control" id="subtitle">
                    </div>
                    <div class="form-group">
                        <label>mainImage</label>
                        <input type="text" class="form-control" id="mainImage">
                    </div>
                    <div class="form-group">
                        <label>subImages</label>
                        <input type="text" class="form-control" id="subImages">
                    </div>
                    <div class="form-group">
                        <label>详细</label>
                        <textarea class="form-control" rows="6" id="detail"></textarea>
                    </div>
                    <div class="form-group">
                        <label>价格</label>
                        <input type="text" class="form-control" id="price">
                    </div>
                    <div class="form-group">
                        <label>排序</label>
                        <input type="text" class="form-control" id="stock">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <input type="text" class="form-control" id="status">
                    </div>
                </form>
                <%-- 编辑表单结束 --%>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveEdit">确定</button>
            </div>
        </div>
    </div>
</div>
<%-- 提示窗 --%>
<div class="modal fade" id="RESModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                内容
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>



</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/productList.js"></script>
</html>
