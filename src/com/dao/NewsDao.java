package com.dao;

import com.newsmanager.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 方法描述：查询所有新闻集合
 * 新闻集合
 */

public class NewsDao {


    /**
     * 方法描述  修改新闻
     */
    public int updateNews(Integer id,String newsTitle,String newsType,String newsContent){
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3","root","");
            //3.获取statement，执行sql
            String sql = "update news set newstitle=?,newstype=?,newscontent=? where newsid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, newsTitle);
            statement.setObject(2, newsType);
            statement.setObject(3, newsContent);
            statement.setObject(4, id);
            row = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
                if (statement!=null) {
                    statement.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }


    /**
     * 方法描述  根据新闻主键查询新闻对象
     * @return 新闻对象
     */
    public News getNews(Integer id){
        News news = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3","root","");
            //3.获取statement，执行sql
            String sql = "select * from news where newsid=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //4.执行sql返回结果集并解析
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int newsId = resultSet.getInt("newsid");
                String newsTitle = resultSet.getString("newstitle");
                String newsContent = resultSet.getString("newscontent");
                String newsStatus = resultSet.getString("newsStatus");
                String newsType = resultSet.getString("newsType");
                Date createTime = resultSet.getDate("createTime");
                news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
                if (statement!=null) {
                    statement.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return news;
    }


    /**
     * 方法描述   删除新闻
     * @param id 新闻主键id
     * @return 数据库受影响的行数
     */
    public int deleteNewsById(Integer id){
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3","root","");
            //3.获取statement，执行sql
            String sql = "delete from news where newsid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            row = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
                if (statement!=null) {
                    statement.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }



    /**
     * 方法描述  审核新闻
     * 新闻主键id
     * 数据库受影响的行数
     */
    public int shenheNews(Integer id){
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3","root","");
            //3.获取statement，执行sql
            String sql = "update news set newsstatus='已审核' where newsid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            row = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
                if (statement!=null) {
                    statement.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    /*方法描述：添加新闻的方法
    * newstitle:新闻标题
    * newstype新闻栏目
    * content新闻正文
    * 数据库受影响的行数*/
    public int addNews(String newstitle,String newstype,String content){
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3", "root", "");
            //3.获取statement，执行sql
            String sql = "insert into news(newstitle,newscontent,newsstatus,newstype,createtime) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,newstitle);
            statement.setString(2,newstype);
            statement.setString(3,"未审核");
            statement.setString(4,newstype);
            statement.setDate(5,new java.sql.Date(2016,3,12));
            row = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }


    public List<News> getNewsList(Integer pageNumber, Integer pageSize) {
        List<News> newsList = new ArrayList<News>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;//查询需要返回的结果集ResultSet
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3", "root", "");
            //3.获取statement，执行sql
            statement = connection.createStatement();
            //4.执行sql返回结果集并解析
            int starSize = (pageNumber - 1) * pageSize;
            resultSet = statement.executeQuery("select * from news limit " + starSize + "," + pageSize);
            //结果集得到后就要循环解析结果集
            while (resultSet.next()) {
                //一共6个值，下面定义一些变量来收取它们的值
                int newsId = resultSet.getInt("newsid");
                String newsTitle = resultSet.getString("newstitle");
                String newsContent = resultSet.getString("newsContent");
                String newsStatus = resultSet.getString("newsStatus");
                String newsType = resultSet.getString("newsType");
                Date createTime = resultSet.getDate("createtime");
                //循环获取到字段之后需要把它封装到对象里面去
                News news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return newsList;
    }
    //方法描述 查询新闻总条数

    public int getCount() {
        int count = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理器获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zyf3", "root", "");
            //3.获取statement，执行sql
            statement = connection.createStatement(); 
            resultSet = statement.executeQuery("select count(*) from news");
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
        }
    }
}


