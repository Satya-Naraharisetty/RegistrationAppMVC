package com.mvc.registrationappmvc;

import java.sql.*;

public class Model {
    private String name;
    private int age;
    private String city;
    private String email;
    private String password;
    private int row;

    private Connection dbConn;
    private PreparedStatement pstmt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int register(){
        try {
            dbConn = JDBCUtils.getDBConnection();
            String sql = "INSERT INTO details(Name, Age, City, Email, Password) VALUES (?,?,?,?,?)";
            pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, city);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            row = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                JDBCUtils.CloseResources(pstmt, dbConn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }
}
