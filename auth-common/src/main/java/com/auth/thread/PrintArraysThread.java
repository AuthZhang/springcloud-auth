package com.auth.thread;

/**
 * 两个线程交替打印数组
 */
public class PrintArraysThread {

    public static void main(String[] args) {
        int[] params = {2, 4, 6, 8, 0};

        for (int i = 0; i < params.length; i++) {
            System.out.println(i & 1);
        }
        System.out.println("--");
        Object lock = new Object();
        Thread t1 = new Thread(()  -> {
            synchronized (lock) {
                for (int i = 0; i < params.length; i++) {
                    if ((i & 1) == 0){
                        System.out.println(params[i]);
                        lock.notifyAll();
                        break;
                    }
                    try {
                        lock.wait();
                    }catch (InterruptedException e){

                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                synchronized (lock) {
                    if ((i & 1) == 1){
                        System.out.println(params[i]);
                        lock.notifyAll();
                        break;
                    }
                    try {
                        lock.wait();
                    }catch (InterruptedException e){

                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
