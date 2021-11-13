package com.zhangyu.authweb.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        AtomicInteger auto = new AtomicInteger(1);
        Thread thread2;
        Thread thread3;
        Thread thread1 = new Thread(()->{
            for(int i= 0;i<10;i++){
                while(auto.get() != 1){
                }
                System.out.println("A");
                auto.set(2);
            }
        });
        thread2 = new Thread(()->{
            for(int i= 0;i<10;i++){
                while(auto.get() != 2){
                }
                System.out.println("B");
                auto.set(3);
            }
        });
        thread3 = new Thread(()->{
            for(int i= 0;i<10;i++){
                while(auto.get() != 3){
                }
                System.out.println("C");
                auto.set(1);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
