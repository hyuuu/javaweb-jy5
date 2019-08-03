package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.User;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: ProductsDao
 * @author: heyuu
 * @create: 2019-08-03 09:19:26
 * @version: JDK 1.8
 * @description:
 */
public class ProductsDao {
    private QueryRunner qr = PoolUtil.getQR();

    public List<Product> selectAll(Integer page, Integer size) {
        String sql = "select * from products limit ?,?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),page,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
