package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.CategoryService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryController", value = "/manage/category/*")
public class CategoryController extends HttpServlet {
    private CategoryService cs = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rc = null;
        String path = PathUtil.getPath(request.getPathInfo());
        switch (path){
            case "get_category":
                rc = get_categoryDo(request);
                break;
            case "add_category":
                rc = add_categoryDo(request);
                break;
            case "set_category_name":
                rc = set_category_nameDo(request);
                break;
            case "get_deep_category":
                rc = get_deep_categoryDo(request);
                break;
        }
        //5、返回响应数据
        response.getWriter().write(rc.toString());
    }

    private ResponseCode get_deep_categoryDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String categoryId = request.getParameter("categoryId");
        rc = cs.get_deep_category(categoryId);
        return rc;
    }

    //修改品类名字
    private ResponseCode set_category_nameDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String categoryId = request.getParameter("categoryId");
        String categoryName = request.getParameter("categoryName");
        rc = cs.set_category_name(categoryId,categoryName);
        return rc;
    }

    //增加节点
    private ResponseCode add_categoryDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String categoryName = request.getParameter("categoryName");
        //String parentId = request.getParameter("parentId");
        rc = cs.add_category(categoryName);
        return rc;
    }

    //获取品类子节点(平级)
    private ResponseCode get_categoryDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String categoryId = request.getParameter("categoryId");
        rc = cs.get_category(categoryId);
        return rc;
    }
}
