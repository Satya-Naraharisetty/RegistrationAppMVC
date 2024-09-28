package com.mvc.registrationappmvc;

import java.sql.*;

public class JDBCUtils {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver registered");
    }

    public static Connection getDBConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/RegistrationAppMVC";
        String user = "root";
        String password = "2408";

        return DriverManager.getConnection(url, user, password);
    }

    public static void CloseResources(PreparedStatement pstmt, Connection dbConn) throws SQLException {
        if (dbConn != null){
            dbConn.close();
        }
        if (pstmt != null){
            pstmt.close();
        }
    }
}
