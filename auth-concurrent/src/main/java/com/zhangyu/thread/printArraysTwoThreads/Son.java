package com.zhangyu.thread.printArraysTwoThreads;

import java.util.concurrent.Executors;

public class Son extends Father{

    static {
        System.out.println("son 静态代码块");
    }

    private static Integer field1 = get();

    static int get(){
        System.out.println("son 静态成员变量");
        return 1;
    }
    {
        System.out.println("son 普通代码块");
    }


    Son(){
        System.out.println("son 构造函数");
    }
    public static void main(String[] args) {
    }
}
