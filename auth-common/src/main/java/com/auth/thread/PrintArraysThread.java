package com.auth.thread;

import java.util.concurrent.Semaphore;
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
     * 如果线程要执行时发现标示不对，则一直while自旋等待
     * 当自旋值不是自己的值时，循环等待
     * 当自旋值是自己的值时，执行打印，同时将自旋值设置为另一个线程的自旋值，让另一个线程得以执行
     */
    private static void method3() {
        int[] params = {2, 4, 6, 8, 0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<params.length;i++){
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
            for (int i = 0; i<params.length;i++){
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

    private static final Semaphore semaphore = new Semaphore(1);
    /**
     * 通过信号量实现
     */
    private static void method4() {
        int[] params = {2, 4, 6, 8, 0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                try {
                    semaphore.acquire();
                }catch (InterruptedException e){
                }
                //奇数
                if ((i & 1) == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                }
                semaphore.release();
            }
        }, "奇数位线程");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < params.length; i++) {
                try {
                    semaphore.acquire();
                }catch (InterruptedException e){
                }
                //偶数
                if ((i & 1) == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + params[i]);
                }
                semaphore.release();
            }
        }, "偶数位线程");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        method4();
    }
}
