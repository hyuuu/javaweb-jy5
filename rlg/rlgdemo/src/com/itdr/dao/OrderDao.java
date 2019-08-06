package com.itdr.dao;

import com.itdr.pojo.Category;
import com.itdr.pojo.Order;
import com.itdr.utils.PoolUtil;
import com.itdr.utils.TimeStampUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Class: OrderDao
 * create: 2019-08-06 19:27:54
 *
 * @version: JDK 1.8
 * @author: heyuu
 * <p>
 * description:
 */
public class OrderDao {
    private QueryRunner qr = PoolUtil.getQR();
    public Order selectByOrderNo(String orderNo) {
        String sql = "select * from orders where orderNo = ?";
        Order o = null;
        try {
            o = qr.query(sql,new BeanHandler<Order>(Order.class),orderNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    public List<Order> selectAll(Integer page, Integer size) {
        String sql = "select * from orders limit ?,?";
        List<Order> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Order>(Order.class),page,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Integer updateByOrderNo(String orderNo) {
        String sql = "update orders set status=?, sendTime=? where orderNo=?";
        Integer row = null;
        try {
            row = qr.update(sql,0,TimeStampUtil.getTimestamp(),orderNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
