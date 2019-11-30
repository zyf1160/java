package com.object;

public class Student2 {
    //成员变量
    int id;
    String name;
    int age;

    Computer comp;//计算机

    //方法
    void study(){
        System.out.println("在学习"+"用的电脑是"+comp.brand);
    }
    void paly(){
        System.out.println("在玩游戏");
    }

    public static void main(String[] args) {
        Student2 s2 = new Student2();
        s2.id = 1001;
        s2.name = "张三";
        s2.age = 22;

        Computer c1 = new Computer();
        c1.brand = "联想";

        s2.comp = c1;
        s2.study();
    }
}
class Computer{
    String brand;
}
