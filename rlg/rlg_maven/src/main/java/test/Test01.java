package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * @ClassName: Test01
 * @author: heyuu
 * @create: 2019-07-25 16:01:09
 * @version: JDK 1.8
 * @description:
 */
public class Test01 {

    public static void main(String[] args) {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from users";
        List<Users> users = null;
        try {
            users = qr.query(sql, new BeanListHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users != null){
            for (Users u : users){
                System.out.println(u);
            }
        }


//        ComboPooledDataSource cd = new ComboPooledDataSource();
//
//        String sql = "select * from users";
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet res = null;
//        try {
//            conn = cd.getConnection();
//            ps = conn.prepareStatement(sql);
//            res = ps.executeQuery();
//            while (res.next()){
//                System.out.println(res.getString(1)+"\t"+res.getString(2)+
//                        "\t"+res.getString(3)+"\t"+res.getString(4));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=Hongkong&useUnicode=true&characterEncoding=UTF-8",
//                    "root",
//                    "root"
//
//            );
//            String sql = "select * from users";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet r = ps.executeQuery();
//            while (r.next()){
//                System.out.println(r.getString(2));
//            }
//        } catch (Exception e) {
//
//
//        }

    }
}
