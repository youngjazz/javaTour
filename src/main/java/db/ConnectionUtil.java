package db;

import java.sql.*;

/**
 * Created by leon on 2017/7/27.
 */
public class ConnectionUtil {
    private static Connection conn = null;
    private static String url = "jdbc:mysql://localhost:3307/test";
    private static String user = "root";
    private static String password = "123456";

    public static Connection getConn(){
        try {
            //ClassLoader,加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = ConnectionUtil.getConn();
        String sql = "select * from enum_test";
        try {
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet resultSet = psm.executeQuery();
            int count =  resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
                    System.out.println(resultSet.getString("e")+"\t");
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


    }
}
