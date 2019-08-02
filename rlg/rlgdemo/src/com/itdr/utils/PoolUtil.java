package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @ClassName: PoolUtil
 * @author: heyuu
 * @create: 2019-07-31 11:33:05
 * @version: JDK 1.8
 * @description:
 */
public class PoolUtil {
    private static final ComboPooledDataSource cs = new ComboPooledDataSource();
    private static final QueryRunner qr = new QueryRunner(cs);

    public static QueryRunner getQR(){ return qr; }
    public static ComboPooledDataSource getCS(){
        return cs;
    }
}
