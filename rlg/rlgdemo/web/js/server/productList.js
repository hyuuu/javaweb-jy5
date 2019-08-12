$(document).ready(function(){
    $.post(
        "/manage/product/list.do",
        function (e) {
            if (e.status === "0"){
                e = e.data;
                $("#dataTable").empty();
                var th = "<tr>" +
                    "                    <th>ID</th>" +
                    "                    <th>名称</th>" +
                    "                    <th>标题</th>" +
                    "                    <th>价格</th>" +
                    "                    <th>状态</th>" +
                    "                    <th>上架时间</th>" +
                    "                    <th>更新时间</th>" +
                    "                    <th>操作</th>" +
                    "                </tr>";
                $("#dataTable").append(th);
                for (var i = 0; i < e.length; i++) {
                    var td =
                        "<tr>"+
                        "<td>"+e[i].id+"</td>" +
                        "<td>"+e[i].name+"</td>" +
                        "<td>"+e[i].subtitle+"</td>" +
                        "<td>"+e[i].price+"</td>" +
                        "<td>"+e[i].status+"</td>" +
                        "<td>"+e[i].createTime+"</td>" +
                        "<td>"+e[i].updateTime+"</td>" +
                        "<td>" +
                        "   <button class=\"btn btn-default btn-xs\" name='editProduct' value='"+e[i].id+"' type=\"button\">编辑</button>" +
                        "   <button class=\"btn btn-danger btn-xs \"  type=\"button\">下架</button>" +
                        "</td>"+
                        "</tr>";
                    $("#dataTable").append(td);
                }
            }else {
                alert(e.msg);
            }
        }
    );
    function plist(){
        $.post(
            "/manage/product/list.do",
            function (e) {
                if (e.status === "0"){
                    e = e.data;
                    $("#dataTable").empty();
                    var th = "<tr>" +
                        "                    <th>ID</th>" +
                        "                    <th>名称</th>" +
                        "                    <th>标题</th>" +
                        "                    <th>价格</th>" +
                        "                    <th>状态</th>" +
                        "                    <th>上架时间</th>" +
                        "                    <th>更新时间</th>" +
                        "                    <th>操作</th>" +
                        "                </tr>";
                    $("#dataTable").append(th);
                    for (var i = 0; i < e.length; i++) {
                        var td =
                            "<tr>"+
                            "<td>"+e[i].id+"</td>" +
                            "<td>"+e[i].name+"</td>" +
                            "<td>"+e[i].subtitle+"</td>" +
                            "<td>"+e[i].price+"</td>" +
                            "<td>"+e[i].status+"</td>" +
                            "<td>"+e[i].createTime+"</td>" +
                            "<td>"+e[i].updateTime+"</td>" +
                            "<td>" +
                            "   <button class=\"btn btn-default btn-xs\" name='editProduct' value='"+e[i].id+"' type=\"button\">编辑</button>" +
                            "   <button class=\"btn btn-danger btn-xs \"  type=\"button\">下架</button>" +
                            "</td>"+
                            "</tr>";
                        $("#dataTable").append(td);
                    }
                }else {
                    alert(e.msg);
                }
            }
        );
    }

    //编辑
    //点击编辑按钮，显示模态框
    $(document).on("click","button[name='editProduct']",function () {
        var id =  $(this).val();
        // $('#editModal').modal('show');
        $.post(
            "/manage/product/detail.do",
            {
                productId : id
            },
            function (e) {
                if (e.status === "0"){
                    $("#saveEdit").val(id);
                    e = e.data;
                    $("#name").val(e.name);
                    $("#categoryId").val(e.categoryId);
                    $("#subtitle").val(e.subtitle);
                    $("#mainImage").val(e.mainImage);
                    $("#subImages").val(e.subImages);
                    $("#detail").val(e.detail);
                    $("#price").val(e.price);
                    $("#stock").val(e.stock);
                    $("#status").val(e.status);
                    $('#editModal').modal('show');
                } else {
                    alert("完犊子，出bug了...");
                }
            },
            "JSON"
        );
    });
    //点击确认，提交数据
    $(document).on("click","#saveEdit",function () {
        $('#editModal').modal('hide');
        $.post(
            "/manage/product/save.do",
            {
                id : $("#saveEdit").val(),
                name : $("#name").val(),
                categoryId : $("#categoryId").val(),
                subtitle : $("#subtitle").val(),
                mainImage : $("#mainImage").val(),
                subImages : $("#subImages").val(),
                detail : $("#detail").val(),
                price : $("#price").val(),
                stock : $("#stock").val(),
                status : $("#status").val()
            },function (e) {
                if (e.status === "0"){
                    $("#RESModal .modal-body").empty();
                    $("#RESModal .modal-body").append("<p>"+e.data+"</p>");
                    $('#RESModal').modal('show');
                    plist();
                }else {
                    $("#RESModal .modal-body").empty();
                    $("#RESModal .modal-body").append("<p>"+e.msg+"</p>");
                    $('#RESModal').modal('show');
                }
            },
            "JSON"
        );
    });


});
// ready()结束