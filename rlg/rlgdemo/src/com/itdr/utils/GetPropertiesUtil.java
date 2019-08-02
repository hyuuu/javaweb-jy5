package com.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @ClassName: GetPropertiesUtil
 * @author: heyuu
 * @create: 2019-08-01 13:10:39
 * @version: JDK 1.8
 * @description:
 */
public class GetPropertiesUtil {
    public static String getValue(String key) {
        //1、准备流通道，使用InputStreamReader解决乱码问题
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(
                    GetPropertiesUtil.class.getClassLoader().getResourceAsStream("const.properties"),"UTF-8"
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //2、新建properties对象
        Properties p = new Properties();
        //3、加载properties文件
        try {
            p.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4、取值
        String value = p.getProperty(key);
        return value;
    }

    //测试
    public static void main(String[] args) {
        System.out.println(GetPropertiesUtil.getValue("LOGIN_ERROR_MSG"));
    }
}
