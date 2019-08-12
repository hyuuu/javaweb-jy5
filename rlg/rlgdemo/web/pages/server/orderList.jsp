<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 17:59
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
                <tr>
                    <th>订单编号</th>
                    <th>金额</th>
                    <th>支付方式</th>
                    <th>状态说明</th>
                    <th>付款时间</th>
                    <th>发货时间</th>
                    <th>签收时间</th>
                    <th>关闭时间</th>
                    <th>下单时间</th>
                    <th>买家ID</th>
                    <th>买家昵称</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<%-- 提示窗 --%>
<div class="modal fade" id="orderRESModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
<script src="../../js/server/orderList.js"></script>
</html>
