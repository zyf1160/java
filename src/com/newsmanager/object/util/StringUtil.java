package com.newsmanager.object.util;

public class StringUtil {
    public static void print(Object B1,Object B2){
        String result = format(B1,B2);
        System.out.println(result);
    }



    public static String format(Object o1,Object o2){
        String result = o1+":"+o2;
        return result;
    }


    public static String montage(String string01,String string03){
        String result = string01 +":"+ string03;
        return result;
    }


    public static void main(String[] args) {
        //montage("AB","CD");
        String a1 = format("aa",1);
        System.out.println(a1);
        print("姓","名");

    }
}
