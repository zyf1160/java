package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        tastList();
//        HashMap();
//        tastListUser();
    }
private static HashMap<String,String> HashMap(){
    HashMap<String,String> user = new HashMap<>();
//    map.put("陈","男");
//    System.out.println(map.containsKey("陈"));

//    map.clear();
//    user.put("name",new News());
    user.put("sex","男");
    user.put("age","27");
    user.put("job","程序员");


    System.out.println(user.get("name"));
//
//    for (Map.Entry<String,String> entry : user.entrySet()){
//        String why = entry.getKey();
//        String value = entry.getValue();
////        System.out.println(why+","+value);
//    }
return user;
}

        private static void tastList() {
            ArrayList<String > array = new ArrayList<String>();
            String name="chenhuang";
            array.add(name);
            array.add("陈奇");
            array.add("赵露");
            array.add("云飞");
            for(int i=0;i<array.size();i++){
                String a = array.get(i);
                System.out.println(a);
            }
    }
        private static void tastListUser() {
            ArrayList<HashMap<String,String>> array = new ArrayList<>();
            array.add(HashMap());
            array.add(HashMap());
//            array.add("赵露");
//            array.add("云飞");
            for(int i=0;i<array.size();i++){
                HashMap<String,String> B = array.get(i);
                String C = B.get("sex");
                System.out.println(C);
                System.out.println(B.get("job"));
                System.out.println(array.get(i));
            }
    }
}
