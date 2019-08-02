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

    public static QueryRunner getQR(){
        QueryRunner queryRunner = new QueryRunner(cs);
        return queryRunner;
    }
    public static ComboPooledDataSource getCS(){
        return cs;
    }
}
