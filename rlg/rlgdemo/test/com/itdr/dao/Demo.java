package com.itdr.dao;

import com.itdr.pojo.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date();
//        Timestamp timestamp = new Timestamp(date.getTime());
//        System.out.println(timestamp);

        long ts = System.currentTimeMillis();
        System.out.println("-----ts-----"+ts);

        String string = ts+"";
        String s = string.substring(0,10);
        int i = Integer.parseInt(s);
        System.out.println("-----i-----"+i);

        String a = i+"000";
        System.out.println("-----a-----"+a);
        long ll = Long.parseLong(a);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(ll));


    }
    @Test
    public void m3(){
        BigDecimal bd = new BigDecimal("3.44");
        BigDecimal bd2 = new BigDecimal("1.24");
        //直接使用double，会带有浮点型的不可预知性，建议使用String
        BigDecimal bd3 = new BigDecimal(7.89);
        System.out.println(bd);
        System.out.println(bd3);

        //加法
        //错误
        bd.add(bd2);
        System.out.println(bd);
        //正确
        bd = bd.add(bd2);
        System.out.println(bd);



    }
}
