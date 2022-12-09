package DataBase;

import java.sql.DriverManager;


import java.sql.*;
import java.sql.ResultSet;

public class JDBC {
    //驱动类
    static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //连接字符串
    static String url = "jdbc:sqlserver://localhost;databaseName = test;encrypt=true;trustServerCertificate=true";
    //密码
    static String password = "123";

    // 用户名
    static String username = "sa";

    static Connection conn = null;

    static PreparedStatement pstmt = null;

    static ResultSet rs = null;


    public  Connection connectionDatabase() {

        try {

            Class.forName(driverClass);

            conn = DriverManager.getConnection(url, username, password);

            return conn;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

