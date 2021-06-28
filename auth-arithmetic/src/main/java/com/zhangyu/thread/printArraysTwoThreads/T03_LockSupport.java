package com.zhangyu.thread.printArraysTwoThreads;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印数组
 */
public class T03_LockSupport {


    private static Thread t2 = new Thread();
    /**
     * 通过LockSupport.unpark(t2);和LockSupport.park();实现
     */
    private static void method() {
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


    public static void main(String[] args) {
        method();
    }
}
