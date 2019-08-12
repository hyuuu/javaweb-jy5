// $(document).ready(function(){
    //用户模块
    //1.用户列表
    $("#userList").click(function () {
        $(".context").load("userList.jsp");
    });

    //商品模块
    //1.商品列表
    $("#productList").click(function () {
        $(".context").load("productList.jsp");
    });
    //2.商品搜索
    $("#productSearch").click(function () {
        $(".context").load("productSearch.jsp");
    });
    //3.图片上传
    $("#productUpload").click(function () {
        $(".context").load("productUpload.jsp");
    });
    //4.增加商品
    $("#productAdd").click(function () {
        $(".context").load("productAdd.jsp");
    });


    //订单模块
    // 1.订单列表
    $("#orderList").click(function () {
        $(".context").load("orderList.jsp");
    });
// });
