package com.itdr.dao;

import com.itdr.pojo.Category;
import com.itdr.utils.PoolUtil;
import com.itdr.utils.TimeStampUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Class: CategoryDao
 * create: 2019-08-05 20:14:28
 *
 * @version: JDK 1.8
 * @author: heyuu
 * description:
 */
public class CategoryDao {
    private QueryRunner qr = PoolUtil.getQR();
    public List<Category> selectByParentId(Integer parentId) {
        String sql = "select * from category where parentId = ?";
        List<Category> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Category>(Category.class),parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Integer insertWithName(String categoryName) {
        String sql = "insert into category(id,name,status,createTime,updateTime) values(null,?,?,?,?)";
        Integer row = null;
        try {
            row = qr.update(sql,categoryName,0,TimeStampUtil.getTimestamp(),TimeStampUtil.getTimestamp());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Category selectById(Integer id) {
        String sql = "select * from category where id = ?";
        Category category = null;
        try {
            category = qr.query(sql,new BeanHandler<Category>(Category.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public Integer updateCategoryNameById(Integer id, String categoryName) {
        String sql = "update category set name = ? where id = ?";
        Integer row = null;
        try {
            row = qr.update(sql,categoryName,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public List<Category> selectDeepCategoryById(Integer id) {
        /*
         *获取当前分类id及递归子节点categoryId
         */
        String sql = "";
        List<Category> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Category>(Category.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
