package com.zhangyu.thread.printArraysTwoThreads;

public class Father {

    static {
        System.out.println("father 静态代码块");
    }

    private static Integer field1 = get();

    static int get(){
        System.out.println("father 静态成员变量");
        return 1;
    }


    Father(){
        System.out.println("father 构造函数");
    }
    {
        System.out.println("father 普通代码块");
    }


    public static void main(String[] args) {

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String s33 = s3.intern();
        System.out.println(s3 == s33);
    }
}
