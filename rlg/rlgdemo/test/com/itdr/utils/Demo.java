package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: Demo
 * @author: heyuu
 * @create: 2019-07-31 11:24:58
 * @version: JDK 1.8
 * @description:
 */
public class Demo {

    @Test
    public void m1() throws Exception {
        ComboPooledDataSource cs = new ComboPooledDataSource();
        Connection conn = cs.getConnection();
        String sql = "select * from users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while (res.next()){
            System.out.println(res.getString(2));
        }
    }

    @Test
    public void m2(){
        String s = "/set_sale_status.do";
        String path = PathUtil.getPath(s);
        System.out.println(path);
    }
}
