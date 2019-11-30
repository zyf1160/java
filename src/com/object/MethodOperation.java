package com.object;

public class MethodOperation {





    public static void main(String[] args) {
//        testConstructor();
        int result = calculate(2,3);
        System.out.println("result is :"+result);
    }

    private static void testConstructor() {
        Student student01 = new Student();
//        Integer i= new Integer(0);
//        String name=new String("chen");
        student01.setAge(5);
        student01.setName("student01");

        Student student02=new Student();
        student01.setName("student02");
        student02.setAge(9);

//        String
        System.out.println("student01 name is :"+student01.getName());
    }


    public static Integer calculate(int a,int b){
        int sum=a+b;
        return sum ;
    }
}
