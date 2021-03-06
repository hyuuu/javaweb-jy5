package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.User;
import com.itdr.service.UsersService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * 控制层
 */
@WebServlet(name = "UsersController",value = "/manage/user/*")
public class UsersController extends HttpServlet {

    private UsersService us = new UsersService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、解决乱码问题---过滤器解决
        //2、设置统一返回数据对象
        ResponseCode rc = null;
        //3、请求地址拆分，辨别请求
        String path = PathUtil.getPath(request.getPathInfo());

        System.out.println("2--控制器："+path);

        //4、什么样的请求进什么样的路线
        switch (path){
            case "list":
                rc = listDo(request,response);
                break;
            case "login":
                rc = loginDo(request,response);
                break;
            case "disableUser":
                rc = disableUserDo(request);
                break;
            case "enableUser":
                rc = enableUserDo(request);
                break;
            case "yz":
                yzDo(request,response);
                break;
            case "checkStatus":
                rc = checkStatusDo(request);
                break;
        }
        //5、返回响应数据
        System.out.println("3--响应的Data："+rc.getData());

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rc));
    }

    //查看用户状态:status
    private ResponseCode checkStatusDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String id = request.getParameter("id");
        rc = us.checkStatusByID(id);
        return rc;
    }

    private void yzDo(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        System.out.println(username);
        boolean u = us.yanzheng(username);
        try {
            response.getWriter().write(String.valueOf(u));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ResponseCode enableUserDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        //禁用用户ID
        String id = request.getParameter("id");
        rc = us.enableUserByID(id);
        return rc;
    }

    private ResponseCode disableUserDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        //禁用用户ID
        String id = request.getParameter("id");
        rc = us.disableUserByID(id);
        return rc;
    }

    private ResponseCode listDo(HttpServletRequest request,HttpServletResponse response) {
        ResponseCode rc = new ResponseCode();
        String pageNum = request.getParameter("pageNum");   //页码
        String pageSize = request.getParameter("pageSize"); //一页数据量
        rc = us.selectAll(pageNum,pageSize);

//        request.setAttribute("uli",rc);
//        try {
//            request.getRequestDispatcher("/index.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return rc;
    }

    private ResponseCode loginDo(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode rc = us.selectOne(username, password);

        //获取session，保存user信息
        HttpSession session = request.getSession();
        session.setAttribute("user",rc.getData());

        return rc;
    }

}
