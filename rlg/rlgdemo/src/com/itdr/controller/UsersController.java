package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.User;
import com.itdr.service.UsersService;
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
        //4、什么样的请求进什么样的路线
        switch (path){
            case "list":
                rc = listDo(request);
                break;
            case "login":
                rc = loginDo(request);
                break;
        }
        //5、返回响应数据
        response.getWriter().write(rc.toString());
    }

    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断session里有没有user，若有，验证其权限
        if (user == null){
            rc.setStatus("3");
            rc.setMsg("未登录！");
            return rc;
        }
        if (user.getU_type() != 1){
            rc.setStatus("3");
            rc.setMsg("没有权限！");
            return rc;
        }
        String pageNum = request.getParameter("pageNum");   //页码
        String pageSize = request.getParameter("pageSize"); //一页数据量
        rc = us.selectAll(pageNum,pageSize);
        return rc;
    }

    private ResponseCode loginDo(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode rc = us.selectOne(username, password);

        //获取session，保存user信息
        HttpSession session = request.getSession();
        session.setAttribute("user",rc.getData());

        return rc;
    }

}
