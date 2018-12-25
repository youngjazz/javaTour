package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * 批量插入100000条数据
 * Created by leon on 2017/7/27.
 */
public class InsertMysql {
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        Connection conn = ConnectionUtil.getConn();

        String sqlPrefix = "insert into test_student(name,create_time) values";

        //设置事务非自动提交
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            StringBuffer sb = new StringBuffer();
            //外层循环，总提交次数
            for (int i = 0; i < 100; i++) {

                //提交步长
                for (int j = 0; j < 10000; j++) {
                    sb.append("('user_"+i+"_"+j+"',SYSDATE()),");
                }

                //构建完整sql
                String sql = sqlPrefix + sb.substring(0, sb.length()-1);
                //添加执行sql
                pst.addBatch(sql);
                //执行操作
                pst.executeBatch();
                //提交事务
                conn.commit();
                sb = new StringBuffer();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        long endTime = new Date().getTime();
        System.out.println("cost: "+(endTime-startTime)+"ms");

    }
}
