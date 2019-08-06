package com.itdr.dao;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.pojo.User;
import com.itdr.utils.PoolUtil;
import com.itdr.utils.TimeStampUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.math.BigDecimal;
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
        String sql = "select id,categoryId,name,subtitle,mainImage,status,price from products limit ?,?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),page,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public List<Product> selectLikeName(String productName) {
        String sql = "select * from products where name like ?";
        productName = "%"+productName+"%";
        List<Product> product = null;
        try {
            product = qr.query(sql,new BeanListHandler<Product>(Product.class),productName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product selectById(Integer id) {
        String sql = "select * from products where id=?";
        Product product = null;
        try {
            product = qr.query(sql,new BeanHandler<Product>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Integer updateStatusById(Integer id, Integer status) {
        String sql = "update products set status = ? where id = ?";
        Integer row = null;
        try {
            row = qr.update(sql,status,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer insertAll(Integer categoryId, String name, String subtitle, String mainImage, String subImages,
                             String detail, BigDecimal price, String stock, Integer status) {
        String sql = "insert into products values(null,?,null,?,?,null,?,?,?,?,?,?,?,?)";
        Integer row = null;
        try {
            row = qr.update(sql,categoryId,name,subtitle,mainImage,subImages,detail,price,stock,status,TimeStampUtil.getTimestamp(),TimeStampUtil.getTimestamp());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateAll(Integer categoryId, String name, String subtitle, String mainImage, String subImages,
                             String detail, BigDecimal price, String stock, Integer status, Integer id) {
        String sql = "update products set categoryId=?, name=?, subtitle=?, mainImage=?, subImages=?, " +
                     " detail=?, price=?, stock=?, status=?, updateTime=? where id=?";
        Integer row = null;
        try {
            row = qr.update(sql,categoryId,name,subtitle,mainImage,subImages,detail,price,stock,status,TimeStampUtil.getTimestamp(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
