package com.newsmanager.object;

public class Student {
    private String name;
    private Integer age;
    private static String country;

    void study(){
        System.out.println("在学习");
    }
    void play(){
        System.out.println("在玩吃鸡");
    }


    public static void main(String[] args) {
        Student sd = new Student();
        sd.study();
        sd.play();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
