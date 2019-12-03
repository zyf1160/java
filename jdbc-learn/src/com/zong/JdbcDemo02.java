package com.zong;

import domain.User02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo02 {
    public static void main(String[] args) throws Exception {
        List<User02> user02List = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.107/jdbc_learn", "root", "");
        String sql = "select count(*) AS count from user";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Integer count=0;
        while (rs.next()){
 //           count=rs.getInt("count");
   //         System.out.println("总量是："+count);
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            Integer age = rs.getInt("age");
            Integer sex = rs.getInt("sex");
            String phone = rs.getString("phone");
            System.out.println(id+"\t姓名："+name+"\t年龄："+age+"\t性别："+sex+"\t手机号码："+phone);
            User02 u02 = new User02();
            u02.setId(id);
            u02.setName(name);
            u02.setAge(age);
            u02.setSex(sex);
            u02.setPhone(phone);
            user02List.add(u02);
        }
      /*  for (int i = 0;i<user02List.size();i++){
            User02 user = user02List.get(i);
            //System.out.println(user);
        }*/
      conn.close();
      stmt.close();
      rs.close();

    }
}
