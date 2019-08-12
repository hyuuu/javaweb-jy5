package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController", value = "/manage/order/*")
public class OrderController extends HttpServlet {

    private OrderService os = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rc = null;
        String path = PathUtil.getPath(request.getPathInfo());
        switch (path){
            case "detail":
                rc = detailDo(request);
                break;
            case "search":
                rc = detailDo(request);
                break;
            case "list":
                rc = listDo(request);
                break;
            case "send_goods":
                rc = send_goodsDo(request);
                break;
        }
        //5、返回响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rc));
    }

    private ResponseCode send_goodsDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String orderNo  = request.getParameter("orderNo");
        rc = os.sendGoods(orderNo);
        return rc;
    }

    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String pageNum  = request.getParameter("pageNum");
        String pageSize  = request.getParameter("pageSize");
        rc = os.list(pageNum,pageSize);
        return rc;
    }

    //订单详情、按订单号查询
    private ResponseCode detailDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String orderNo  = request.getParameter("orderNo");
        rc = os.detail(orderNo);
        return rc;
    }
}
