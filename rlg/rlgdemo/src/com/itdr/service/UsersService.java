package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UsersDao;
import com.itdr.pojo.User;
import com.itdr.utils.GetPropertiesUtil;

import java.util.List;

/**
 * @ClassName: UsersService
 * @author: heyuu
 * @create: 2019-07-31 13:02:21
 * @version: JDK 1.8
 * @description: 业务层
 */
@SuppressWarnings({"unchecked"})
public class UsersService {

    private UsersDao ud = new UsersDao();

    public ResponseCode selectAll(String pageNum, String pageSize) {
        //创建一个统一返回对象
        ResponseCode<Object> rc = null;
        //1、页码和一页数据量非空判断，若空则初始化
        if (pageNum==null || pageNum.equals("")){pageNum = "1";}
        if (pageSize==null || pageSize.equals("")){pageSize = "10";}
        //2、字符串转数值
        Integer page = null;
        Integer size = null;
        try {
            page = Integer.parseInt(pageNum);
            size = Integer.parseInt(pageSize);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        //3、查数据
        List<User> uli = ud.selectAll(page,size);
        //4、查询失败/出错
        if (uli == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_ERROR_CODE"), GetPropertiesUtil.getValue("SELECT_ERROR_MSG"));
            return rc;
        }
        //5、查询结果集没有数据
        if (uli.size() == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"), GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        //6、查询结果集有数据
        rc = ResponseCode.success(uli);
        return rc;
    }

    public ResponseCode selectOne(String username, String password) {
        //1、创建一个统一返回对象
        ResponseCode rc = null;
        //2、非空判断
        if (username == null || username.equals("") || password == null || password.equals("")) {
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("LOGIN_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("LOGIN_NULLPARAMETER_MSG"));
            return rc;
        }
        //3、查这个人
        User u = ud.selectOne(username, password);
        //4、如果没有这个人
        if (u == null) {
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("LOGIN_ERROR_CODE"), GetPropertiesUtil.getValue("LOGIN_ERROR_MSG"));
            return rc;
        }
        //5、如果这个人权限不足（非管理员）
        if (u.getRole() != 1) {
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("LOGIN_DENIED_CODE"), GetPropertiesUtil.getValue("LOGIN_DENIED_MSG"));
            return rc;
        }
        //6、这个人是管理员
        rc = ResponseCode.success(u);
        //7、返回
        return rc;
    }

    public ResponseCode disableUserByID(String id) {
        //1.实例化一个统一返回对象
        ResponseCode rc = null;
        //2.ID数据类型转换：String--Integer
        Integer uid = null;
        try {
            uid = Integer.parseInt(id);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        //3.查找这个人
        User user = ud.selectByID(uid);
        //4.如果没有这个人
        if (user == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"), GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        //5.如果这个人已经被禁用
        if (user.getStatus() == 1){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("USER_STATS_CODE"), GetPropertiesUtil.getValue("USER_STATS_MSG"));
            return rc;
        }
        //6.禁用这个人
        Integer row = ud.setStatus1ByID(uid);
        //7.如果禁用失败
        if (row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
            return rc;
        }
        //8.成功
        rc = ResponseCode.success(row);
        return rc;
    }

    public ResponseCode enableUserByID(String id) {
        //1.实例化一个统一返回对象
        ResponseCode rc = null;
        //2.ID数据类型转换：String--Integer
        Integer uid = null;
        try {
            uid = Integer.parseInt(id);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        //3.查找这个人
        User user = ud.selectByID(uid);
        //4.如果没有这个人
        if (user == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"), GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        //5.如果这个人已经被启用
        if (user.getStatus() == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("USER_STATS_CODE"), GetPropertiesUtil.getValue("USER_STATS_MSG"));
            return rc;
        }
        //6.禁用这个人
        Integer row = ud.setStatus0ByID(uid);
        //7.如果禁用失败
        if (row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
            return rc;
        }
        //8.成功
        rc = ResponseCode.success(row);
        return rc;
    }
}
