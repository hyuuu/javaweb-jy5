package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 后台页面(manage)权限过滤器l
 */
@WebFilter(filterName = "JurisdictionFilter",value = "/manage/*")
public class JurisdictionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //统一乱码解决
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        //获得请求路径，如果是登录请求就直接放行
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("/login.do")){
            chain.doFilter(req, resp);
            return;
        }
        //获取session，拿出user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //未登录状态
        if (user == null){
            ResponseCode rc = new ResponseCode();
            rc.setStatus(GetPropertiesUtil.getValue("LOGIN_NOT_CODE"));
            rc.setMsg(GetPropertiesUtil.getValue("LOGIN_NOT_MSG"));
            resp.getWriter().write(rc.toString());
            return;
        }
        //权限不足状态
        if (user.getU_type() != 1){
            ResponseCode rc = new ResponseCode();
            rc.setStatus(GetPropertiesUtil.getValue("LOGIN_DENIED_CODE"));
            rc.setMsg(GetPropertiesUtil.getValue("LOGIN_DENIED_MSG"));
            resp.getWriter().write(rc.toString());
            return;
        }
        //正常状态
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
