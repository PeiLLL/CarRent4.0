package DataBase;

import java.sql.DriverManager;


import java.sql.*;
import java.sql.ResultSet;

public class JDBC {
    //������
    static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //�����ַ���
    static String url = "jdbc:sqlserver://localhost;databaseName = test;encrypt=true;trustServerCertificate=true";
    //����
    static String password = "123";

    // �û���
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

