package com.zong;

import domain.User02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo04 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        jdbcLimit();

    }
    public static void jdbcLimit() throws ClassNotFoundException, SQLException {
        List<User02> user02List = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection coot = DriverManager.getConnection("jdbc:mysql://192.168.1.107/jdbc_learn", "root", "");
        String sql = "select * from user limit 3";
        Statement statement = coot.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            Integer age = rs.getInt("age");
            Integer sex = rs.getInt("sex");
            String phone = rs.getString("phone");
            System.out.println(id+"\t姓名："+name+"\t年龄："+age+"\t性别："+sex+"\t手机号码："+phone);
            User02 user02 = new User02();
            user02.setId(id);
            user02.setName(name);
            user02.setAge(age);
            user02.setSex(sex);
            user02.setPhone(phone);
            user02List.add(user02);
        }
        /*for (int i = 0;i<user02List.size();i++){
            User02 user = user02List.get(i);
            System.out.println(user);
        }*/
        coot.close();
        statement.close();
        rs.close();
    }
}
