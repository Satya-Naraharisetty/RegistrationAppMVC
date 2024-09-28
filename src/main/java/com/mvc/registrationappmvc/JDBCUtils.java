package com.mvc.registrationappmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getDBConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/RegistrationAppMVC";
        String user = "root";
        String password = "2408";

        return DriverManager.getConnection(url, user, password);
    }

    public static void CloseResources(PreparedStatement pstmt, Connection dbConn) throws SQLException {
        pstmt.close();
        dbConn.close();
    }
}
