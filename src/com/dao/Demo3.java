package com.dao;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {
        int[] arr= {6,7,8,9,10,11,12,13};
        int a = ArrayMax(arr);
        System.out.println("MAX IS:"+a);
        ArrayMin(arr);
        ArrayMin(arr);
        TastList();

    }


    public static int ArrayMax(int[] arr) {
        //定义参照物
        int Max = arr[0];

        for (int i= 1;i<arr.length;i++){
            if (arr[i]>Max){
                Max=arr[i];
            }
        }
        System.out.println("最大值是"+Max);
        return Max;
    }

    public static void ArrayMin(int[] arr){
        //定义参照物
        int Min = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (Min>arr[0]){
                Min=arr[0];
            }
        }
        System.out.println("最小值是"+Min);
    }

    private static void TastList(){
        ArrayList<Integer> suibian = new ArrayList<>();
        suibian.add(1);
        suibian.add(2);
        suibian.add(3);
        suibian.add(4);

        for (int i=0;i<suibian.size();i++){
            Integer a = suibian.get(i);
            System.out.println(a);
        }

    }
}
