$(document).ready(function(){
    $.post(
        "/manage/order/list.do",
        function (e) {
            if (e.status === "0"){
                e = e.data;
                $("#dataTable").empty();
                var th = "<tr>" +
                    "                    <th>订单编号</th>" +
                    "                    <th>金额</th>" +
                    "                    <th>支付方式</th>" +
                    "                    <th>状态说明</th>" +
                    "                    <th>付款时间</th>" +
                    "                    <th>发货时间</th>" +
                    "                    <th>签收时间</th>" +
                    "                    <th>关闭时间</th>" +
                    "                    <th>下单时间</th>" +
                    "                    <th>买家ID</th>" +
                    "                    <th>买家昵称</th>" +
                    "                    <th>操作</th>" +
                    "                </tr>";
                $("#dataTable").append(th);
                for (var i = 0; i < e.length; i++) {
                    var td =
                        "<tr>"+
                        "<td>"+e[i].orderNo+"</td>" +
                        "<td>"+e[i].payment+"</td>" +
                        "<td>"+e[i].paymentTypeDesc+"</td>" +
                        "<td>"+e[i].statusDesc+"</td>" +
                        "<td>"+e[i].paymentTime+"</td>" +
                        "<td>"+e[i].sendTime+"</td>" +
                        "<td>"+e[i].endTime+"</td>" +
                        "<td>"+e[i].closeTime+"</td>" +
                        "<td>"+e[i].createTime+"</td>" +
                        "<td>"+e[i].shippingId+"</td>" +
                        "<td>"+e[i].receiverName+"</td>" +
                        "<td>" +
                        "   <button class=\"btn btn-default btn-xs\" type=\"button\">编辑</button>" +
                        "</td>"+
                        "</tr>";
                    $("#dataTable").append(td);
                }
            }else {
                $("#orderRESModal .modal-body").empty();
                $("#orderRESModal .modal-body").append("<p>"+e.msg+"</p>");
                $('#orderRESModal').modal('show');
            }
        }
    );
});