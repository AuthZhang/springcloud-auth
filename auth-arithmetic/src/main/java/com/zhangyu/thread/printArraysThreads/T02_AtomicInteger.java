package com.zhangyu.thread.printArraysThreads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类自旋
 * 两个线程交替打印数组
 */
public class T02_AtomicInteger {


    private static final AtomicInteger flag = new AtomicInteger(1);

    /**
     * 通过原子类AtomicInteger自旋判断本线程是否应该执行
     * 如果线程要执行时发现标示不对，则一直while自旋等待
     * 当自旋值不是自己的值时，循环等待
     * 当自旋值是自己的值时，执行打印，同时将自旋值设置为另一个线程的自旋值，让另一个线程得以执行
     */
    private static void method3() {
        int[] params = {2, 4, 6, 8, 0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                while (flag.get() != 1) {
                }
                //奇数
                if ((i & 1) == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    flag.set(2);
                }
            }
        }, "奇数位线程");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                while (flag.get() != 2) {
                }
                //偶数
                if ((i & 1) == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                    flag.set(1);
                }
            }

        }, "偶数位线程");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        method3();
    }
}
