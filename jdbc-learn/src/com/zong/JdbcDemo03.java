package com.zong;

import domain.User02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        jdbcCount();
    }

    public static void jdbcCount() throws ClassNotFoundException, SQLException {
        List<User02> user02List = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.107/jdbc_learn", "root", "");
        String sql = "select count(*) AS count from user";
        Statement stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean next =  rs.next();
        System.out.println(next);
        Integer count = null;
        count=rs.getInt("count");
        System.out.println("总量是："+count);
        boolean next02 = rs.next();
        System.out.println(next02);
    }
}
