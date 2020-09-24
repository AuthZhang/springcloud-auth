package com.auth.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印数组
 */
public class PrintArraysThread {

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
                    if ((i & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {

                        }
                    } else {
                        lock.notifyAll();
                    }
                }
            }

        }, "奇数位线程");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < params.length; i++) {

                    //偶数
                    if ((i & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {

                        }
                    } else {
                        lock.notifyAll();
                    }
                }
            }
        }, "偶数位线程");

        t1.start();
        t2.start();
    }

    private static Thread t2 = new Thread();

    /**
     * 通过LockSupport.unpark(t2);和LockSupport.park();实现
     */
    private static void method2() {
        int[] params = {2, 4, 6, 8, 0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                //奇数
                if ((i & 1) == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    LockSupport.unpark(t2);//唤醒t2线程
                    continue;
                } else {
                    //如果非自己处理的数据，则将自己阻塞
                    LockSupport.park();
                }

            }

        }, "奇数位线程");

        t2 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                //偶数
                if ((i & 1) == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    LockSupport.unpark(t1);
                    continue;
                } else {
                    LockSupport.park();
                }
            }
        }, "偶数位线程");

        t1.start();
        t2.start();
    }

    private static final AtomicInteger flag = new AtomicInteger(1);

    /**
     * 通过原子类AtomicInteger自旋判断本线程是否应该执行
     */
    private static void method3() {
        int[] params = {2, 4, 6, 8, 0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                while (flag.get() == 1) {
                    //奇数
                    if ((i & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                        flag.set(2);
                    }
                }

            }
        }, "奇数位线程");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                while (flag.get() == 2) {
                    //偶数
                    if ((i & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                        flag.set(1);
                    }
                }

            }
        }, "偶数位线程");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        method1();
    }

}
