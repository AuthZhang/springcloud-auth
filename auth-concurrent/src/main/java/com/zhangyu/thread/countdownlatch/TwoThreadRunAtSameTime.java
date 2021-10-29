package com.zhangyu.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangyu
 * @Description 两个线程同时执行
 * @Date 21:07 2021/10/17
 */
public class TwoThreadRunAtSameTime {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
            }catch (InterruptedException e){

            }
        });

        Thread thread1 = new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
            }catch (InterruptedException e){

            }
        });

        thread.start();
        thread1.start();
        countDownLatch.countDown();
    }
}
