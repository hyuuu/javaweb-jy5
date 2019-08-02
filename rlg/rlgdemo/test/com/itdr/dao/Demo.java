package com.itdr.dao;

import com.itdr.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName: Demo
 * @author: heyuu
 * @create: 2019-08-01 16:58:52
 * @version: JDK 1.8
 * @description:
 */
public class Demo {
    @Test
    public void m1(){
        UsersDao ud = new UsersDao();
        List<User> list = ud.selectAll(1, 10);
        System.out.println(list.size());
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void m2(){
        UsersDao ud = new UsersDao();

        Integer row = ud.updateByID(3);
        System.out.println(row);
    }
}
