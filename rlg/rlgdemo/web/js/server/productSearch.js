$(document).ready(function () {
    //search输入框请求
    function searchPost(lookMore){
        $.post(
            "/manage/product/searchByKeyWord.do",
            {
                KeyWord : $("#keyWord").val(),
                lookMore: lookMore
            },
            function (e) {
                if (e.status === "0"){
                    e = e.data;
                    $("#showSearch table").empty();
                    $("#searchTab").empty();
                    var tab_th = "<tr>" +
                        "                    <th>ID</th>" +
                        "                    <th>名称</th>" +
                        "                    <th>标题</th>" +
                        "                    <th>价格</th>" +
                        "                    <th>状态</th>" +
                        "                    <th>上架时间</th>" +
                        "                    <th>更新时间</th>" +
                        "                    <th>操作</th>" +
                        "                </tr>";
                    $("#searchTab").append(tab_th);
                    for (var i = 0; i < e.length; i++) {
                        var tr = "<tr><td abbr='"+e[i].id+"'>"+e[i].name+"</td></tr>";
                        $("#showSearch table").append(tr);

                        //填装表格
                        var tab_td = "<tr>\n" +
                            "                    <td>"+e[i].id+"</td>\n" +
                            "                    <td>"+e[i].name+"</td>\n" +
                            "                    <td>"+e[i].subtitle+"</td>\n" +
                            "                    <td>"+e[i].price+"</td>\n" +
                            "                    <td>"+e[i].status+"</td>\n" +
                            "                    <td>"+e[i].createTime+"</td>\n" +
                            "                    <td>"+e[i].updateTime+"</td>\n" +
                            "                    <td>" +
                            "                        <button class=\"btn btn-default btn-xs\" type=\"button\">编辑</button>\n" +
                            "                        <button class=\"btn btn-danger btn-xs\" type=\"button\">禁用</button>\n" +
                            "                    </td>" +
                            "                </tr>";
                        $("#searchTab").append(tab_td);
                    }
                }else {
                    $("#showSearch table").empty();
                    var res_null = "<tr><td>暂无该商品</td></tr>"
                    $("#showSearch table").append(res_null);
                }
            },
            "JSON"
        );
    }
    //搜索框获得焦点时
    $(document).on("focus","#keyWord",function () {
        searchPost();
        $("#showSearch").css("display","block");
    });
    //键盘抬起时
    $(document).on("keyup","#keyWord",function () {
        searchPost();
    });
    //输入框失去焦点时
    $(document).on("blur","#keyWord",function () {
        $("#showSearch").css("display","none");
        $("#showSearch table").empty();
    });
    //搜索框请求列表的点击事件
    /*$(document).on("click","#showSearch tr td",function () {
        var name = $(this).innerText;
        alert(name);
    });*/
    //清空表格
    $(document).on("click","#clearTab",function () {
        $("#searchTab").empty();
        var tab_th = "<tr>" +
            "                    <th>ID</th>" +
            "                    <th>名称</th>" +
            "                    <th>标题</th>" +
            "                    <th>价格</th>" +
            "                    <th>状态</th>" +
            "                    <th>上架时间</th>" +
            "                    <th>更新时间</th>" +
            "                    <th>操作</th>" +
            "                </tr>";
        $("#searchTab").append(tab_th);
    });
    //查看更多
    $(document).on("click","#lookMore",function () {
        var lookMore = $("#lookMore").val();
        searchPost(lookMore);
    });
});