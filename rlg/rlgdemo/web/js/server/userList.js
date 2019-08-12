$(document).ready(function(){
    $.post(
        "/manage/user/list.do",
        function (e) {
            if (e.status === "0"){
                e = e.data;
                $("#dataTable").empty();
                var th = "<tr>" +
                    "                        <th>ID</th>" +
                    "                        <th>用户名</th>" +
                    "                        <th>邮箱</th>" +
                    "                        <th>电话</th>" +
                    "                        <th>角色</th>" +
                    "                        <th>状态</th>" +
                    "                        <th>注册时间</th>" +
                    "                        <th>更新时间</th>" +
                    "                        <th>操作</th>" +
                    "                    </tr>";
                $("#dataTable").append(th);
                for (var i = 0; i < e.length; i++) {
                    var td =
                        "<tr>"+
                        "<td>"+e[i].id+"</td>" +
                        "<td>"+e[i].username+"</td>" +
                        "<td>"+e[i].email+"</td>" +
                        "<td>"+e[i].phone+"</td>" +
                        "<td>"+e[i].role+"</td>" +
                        "<td>"+e[i].status+"</td>" +
                        "<td>"+e[i].createTime+"</td>" +
                        "<td>"+e[i].updateTime+"</td>" +
                        "<td>\n" +
                        "<button class=\"btn btn-default btn-xs\" type=\"button\">编辑</button>" +
                        "<button class=\"btn btn-danger btn-xs\" name='disable' value="+e[i].id+" type=\"button\">禁用</button>" +
                        "</td>"+
                        "</tr>";
                    $("#dataTable").append(td);
                }
            }else {
                alert(e.msg);
            }
        },
        "JSON"
    );

    //用户列表
    function ulist(){
        $.post(
            "/manage/user/list.do",
            function (e) {
                if (e.status === "0"){
                    e = e.data;
                    $("#dataTable").empty();
                    var th = "<tr>" +
                        "                        <th>ID</th>" +
                        "                        <th>用户名</th>" +
                        "                        <th>邮箱</th>" +
                        "                        <th>电话</th>" +
                        "                        <th>角色</th>" +
                        "                        <th>状态</th>" +
                        "                        <th>注册时间</th>" +
                        "                        <th>更新时间</th>" +
                        "                        <th>操作</th>" +
                        "                    </tr>";
                    $("#dataTable").append(th);
                    for (var i = 0; i < e.length; i++) {
                        var td =
                            "<tr>"+
                            "<td>"+e[i].id+"</td>" +
                            "<td>"+e[i].username+"</td>" +
                            "<td>"+e[i].email+"</td>" +
                            "<td>"+e[i].phone+"</td>" +
                            "<td>"+e[i].role+"</td>" +
                            "<td>"+e[i].status+"</td>" +
                            "<td>"+e[i].createTime+"</td>" +
                            "<td>"+e[i].updateTime+"</td>" +
                            "<td>\n" +
                            "<button class=\"btn btn-default btn-xs\" type=\"button\">编辑</button>" +
                            "<button class=\"btn btn-danger btn-xs\" name='disable' value='"+e[i].id+"' type='button'>禁用</button>" +
                            "</td>"+
                            "</tr>";
                        $("#dataTable").append(td);
                    }
                }else {
                    alert(e.msg);
                }
            },
            "JSON"
        );
    }

    //禁用
    //1.点击按钮，显示模态框
    $(document).on("click","button[name='disable']",function () {
        var uid =  $(this).val();
        $.post(
            "/manage/user/checkStatus.do",
            {
                id : uid
            },
            function (e) {
                if (e.status === "0") {
                    $("#saveDisable").val(uid);
                    $('#disableModal').modal('show');
                }else {
                    $("#MSGModal .modal-body").empty();
                    $("#MSGModal .modal-body").append("<p>"+e.msg+"</p>");
                    $('#MSGModal').modal('show');
                }
            },
            "JSON"
        );
    });
    //点击确认，禁用用户
    var a = $(document).on("click","#saveDisable",function() {
        $('#disableModal').modal('hide');
        var uid = $("#saveDisable").val();
        $.post(
            "/manage/user/disableUser.do",
            {
                id : uid
            },
            function (e) {
                if (e.status === "0"){
                    ulist();
                } else {
                    $("#MSGModal .modal-body").empty();
                    $("#MSGModal .modal-body").append("<p>"+e.msg+"</p>");
                    $('#MSGModal').modal('show');
                }
            },
            "JSON"
        );
    });


});

