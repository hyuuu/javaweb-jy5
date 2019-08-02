package com.itdr.utils;

/**
 * @ClassName: PathUtil
 * @author: heyuu
 * @create: 2019-07-31 16:43:57
 * @version: JDK 1.8
 * @description:
 */
public class PathUtil {
    public static String getPath(String path){
        path = path.replace(".","/");
        String[] split = path.split("/");
        return split[1];
    }
}
