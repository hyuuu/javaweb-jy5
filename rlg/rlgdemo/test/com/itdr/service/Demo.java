package com.itdr.service;

import com.itdr.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo
 * @author: heyuu
 * @create: 2019-08-01 16:01:40
 * @version: JDK 1.8
 * @description:
 */
public class Demo {
    @Test
    public void m1(){
        List<User> li = new ArrayList<User>();
        if (li == null){
            System.out.println("li-null");
            System.out.println(li.size());
        }

        li.add(new User());
        System.out.println("li-no-null");
        System.out.println(li.size());
    }
    @Test
    public void m2(){

    }
}
