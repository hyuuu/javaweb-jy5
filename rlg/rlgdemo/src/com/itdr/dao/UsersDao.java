package com.itdr.dao;

import com.itdr.pojo.User;
import com.itdr.utils.PoolUtil;
import com.itdr.utils.TimeStampUtil;
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

    private QueryRunner qr = PoolUtil.getQR();

    public List<User> selectAll(Integer page, Integer size) {
        String sql = "select * from users limit ?,?";
        List<User> uli = null;
        try {
            uli = qr.query(sql, new BeanListHandler<User>(User.class),page,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uli;
    }

    public User selectOne(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";
        User u = null;
        try {
            u = qr.query(sql, new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public User selectByID(Integer id) {
        String sql = "select * from users where id=?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Integer setStatus1ByID(Integer id) {
        String sql = "update users set status=1, updateTime=? where id=?";
        Integer row = 0;
        try {
            row = qr.update(sql, TimeStampUtil.getTimestamp(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer setStatus0ByID(Integer id) {
        String sql = "update users set status=0, updateTime=? where id=?";
        Integer row = 0;
        try {
            row = qr.update(sql, TimeStampUtil.getTimestamp(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
