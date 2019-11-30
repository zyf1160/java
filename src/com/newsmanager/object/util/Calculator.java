package com.newsmanager.object.util;

public class Calculator {


    public static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }


    public static int add(int a,int b){
        int sum = a + b;
        return sum;
    }

    public static int subtract(int a,int b){
        int difference = a - b;
        return difference;
    }

    public static int multiply(int a,int b){
        int quotient = a * b;
        return quotient;
    }

    public static int divide(int a,int b){
        int product = a / b;
        return product;
    }
}
