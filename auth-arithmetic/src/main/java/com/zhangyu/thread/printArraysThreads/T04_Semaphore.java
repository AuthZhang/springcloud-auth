package com.zhangyu.thread.printArraysThreads;

import java.util.concurrent.Semaphore;

/**
 * 未调试通过
 * 两个线程交替打印数组
 */
public class T04_Semaphore {

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
                } catch (InterruptedException e) {
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
                } catch (InterruptedException e) {
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

    public static void main(String[] args) throws Exception {
        method4();

    }


}
