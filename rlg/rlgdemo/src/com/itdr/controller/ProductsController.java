package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductsService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductsController",value = "/manage/product/*")
public class ProductsController extends HttpServlet {

    private ProductsService ps = new ProductsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rc = null;
        String path = PathUtil.getPath(request.getPathInfo());
        switch (path){
            case "list":
                rc = listDo(request);
                break;
            case "search":
                rc = searchDo(request);
                break;
            case "detail":
                rc = detailDo(request);
                break;
            case "set_sale_status":
                rc = set_sale_statusDo(request);
                break;
            case "save":
                rc = saveDo(request);
                break;
        }
        //5、返回响应数据
        response.getWriter().write(rc.toString());
    }

    private ResponseCode saveDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String categoryId = request.getParameter("categoryId");
        String name = request.getParameter("name");
        String subtitle = request.getParameter("subtitle");
        String mainImage = request.getParameter("mainImage");
        String subImages = request.getParameter("subImages");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        rc = ps.save(
                categoryId,
                name,
                subtitle,
                mainImage,
                subImages,
                detail,
                price,
                stock,
                status,
                id
                );
        return rc;
    }

    //产品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productId = request.getParameter("productId");
        String status = request.getParameter("status");
        rc = ps.set_sale_status(productId,status);
        return rc;
    }

    //详情
    private ResponseCode detailDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productId = request.getParameter("productId");
        rc = ps.selectById(productId);
        return rc;
    }

    //产品搜索
    private ResponseCode searchDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productName = request.getParameter("productName");
        String productId = request.getParameter("productId");
        rc = ps.search(productName,productId);
        return rc;

    }

    //产品list
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String pageNum = request.getParameter("pageNum");   //页码
        String pageSize = request.getParameter("pageSize"); //一页数据量
        rc = ps.selectAll(pageNum, pageSize);
        return rc;
    }
}
