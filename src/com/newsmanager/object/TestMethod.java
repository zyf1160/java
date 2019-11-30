package com.newsmanager.object;

import com.newsmanager.object.util.Calculator;
import com.newsmanager.object.util.StringUtil;

public class TestMethod {
    public static void main(String[] args) {
        Calculator.add(5,6);
        Calculator.subtract(9,8);
        Calculator.multiply(5,6);
        Calculator.divide(9,3);
        int res = Calculator.add(5,5);
        System.out.println(res);
        System.out.println("______________");
        int a1 = Calculator.add(5,6);
        int a2 = Calculator.multiply(a1,7);
        int a3 = Calculator.divide(a2,2);
//        System.out.println(StringUtil.format("结果为",a3));
        StringUtil.print("结果为",a3);
        System.out.println("+++++++++++++++++++");
        int b1 = Calculator.add(5,6);
        int b2 = Calculator.add(2,4);
        int b3 = Calculator.add(1,3);
        int b4 = Calculator.multiply(b1,b2);
        int b5 = Calculator.divide(b4,b3);
        //System.out.println("结果为"+b5);
        StringUtil.print("结果为",b5);
        return ;
    }


}