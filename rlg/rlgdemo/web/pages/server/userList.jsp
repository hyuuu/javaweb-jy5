<%--
  Created by IntelliJ IDEA.
  User: 何宇
  Date: 2019/8/10
  Time: 15:25
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
                        <th>用户名</th>
                        <th>邮箱</th>
                        <th>电话</th>
                        <th>角色</th>
                        <th>状态</th>
                        <th>注册时间</th>
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
                            <button class="btn btn-danger btn-xs" type="button" data-toggle="modal" data-target="#disableModal">禁用</button>
                        </td>
                    </tr>--%>
                </table>
                <button type="button" class="btn btn-default btn-sm">上一页</button>
                <button type="button" class="btn btn-default btn-sm">下一页</button>
            </div>
        </div>
    </div>

    <%-- 禁用模态框 --%>
    <div class="modal fade" id="disableModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">禁用用户</h4>
                </div>
                <div class="modal-body">
                    您确定要禁用该用户吗？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="saveDisable">确定</button>
                </div>
            </div>
        </div>
    </div>

    <%-- MSG提示窗 --%>
    <div class="modal fade" id="MSGModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="../../bootstrap-3.3.7-dist/js/jquery-1.12.4.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="../../js/server/userList.js"></script>
</html>