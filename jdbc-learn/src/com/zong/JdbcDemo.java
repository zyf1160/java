package com.zong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<User> userlist = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.107/zyf1", "root", "");
        String sql = "select * from test  ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            int english = resultSet.getInt("english");
            int math = resultSet.getInt("math");
            System.out.println(id + "===" + name + "---" + math + "===" + english);
            User u = new User();
            u.setId(id);
            u.setName(name);
            u.setMath(math);
            u.setEnglish(english);
            userlist.add(u);
            //获取结果
        }
        for (int i = 0; i < userlist.size(); i++) {
            User u = userlist.get(i);
            System.out.println(u);
            String n = u.getName();
            System.out.println(n);
        }
        conn.close();
        preparedStatement.close();
        resultSet.close();
        resultSet.close();
    }
}
