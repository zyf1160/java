package com.zong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();//创建时间类
        System.out.println(date.getTime());

        //格式化当前系统时间：
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定格式为
        String sj = sdf.format(date);//格式化当前日期
        System.out.println(sj);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
            Calendar calendar = Calendar.getInstance();
            Date date1 = calendar.getTime();
            String dateStringParse = simpleDateFormat.format(date1);
            System.out.println(dateStringParse);

    }
}
