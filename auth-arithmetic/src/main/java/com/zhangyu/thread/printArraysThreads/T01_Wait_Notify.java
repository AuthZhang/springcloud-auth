package com.zhangyu.thread.printArraysThreads;

/**
 * 两个线程交替打印数组
 */
public class T01_Wait_Notify {

    /**
     * 一个线程打印奇数位
     * 另一个打印偶数位
     * wait()和notifyAll()实现
     */
    private static void method1() {
        int[] params = {2, 4, 6, 8, 0};
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < params.length; i++) {
                    //奇数
                    lock.notifyAll();
                    if ((i & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //必须要有，因为两个线程最后一步是阻塞，如果线程执行完了还在阻塞肯定不对，必须要唤醒，才能正确结束程序
                lock.notifyAll();
            }
        }, "奇数位线程");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < params.length; i++) {
                    //偶数
                    lock.notifyAll();
                    if ((i & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                lock.notifyAll();
            }
        }, "偶数位线程");
        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        method1();
    }
}
