package com.itdr.dao;

import com.itdr.pojo.User;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: UsersDao
 * @author: heyuu
 * @create: 2019-07-31 13:08:41
 * @version: JDK 1.8
 * @description: 数据层
 */
public class UsersDao {
    public List<User> selectAll(int page, int size) {
        String sql = "select * from users limit ?,?";
        List<User> uli = null;
        QueryRunner qr = PoolUtil.getQR();
        try {
            uli = qr.query(sql, new BeanListHandler<User>(User.class),page,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uli;
    }

    public User selectOne(String username, String password) {
        String sql = "select * from users where u_name = ? and u_pwd = ?";
        User u = null;
        QueryRunner qr = PoolUtil.getQR();
        try {
            u = qr.query(sql, new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
