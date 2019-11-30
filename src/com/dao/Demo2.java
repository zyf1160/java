package com.dao;

import com.newsmanager.entity.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<News > array = new ArrayList<News>();


            int newsId = 12;
            String newsTitle = "标题";
            String newsContent = "内容";
            String newsStatus = "状态";
            String newsType = "类型";
            Date createTime = new Date();
            //循环获取到字段之后需要把它封装到对象里面去
            News news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);

            array.add(news);

        for (int i=0;i<array.size();i++){
            News aNew = array.get(i);
            String C = aNew.getNewsTitle();
            System.out.println(C);
            String B = aNew.getNewsContent();
            System.out.println(B);
        }
    }
}
