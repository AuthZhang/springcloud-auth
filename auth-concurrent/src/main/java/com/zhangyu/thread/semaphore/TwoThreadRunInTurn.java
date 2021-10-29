package com.zhangyu.thread.semaphore;

/**
 * @Author zhangyu
 * @Description 两个线程依次执行，A全部执行完后，B在执行
 * @Date 21:07 2021/10/17
 */
public class TwoThreadRunInTurn {

    /**
     * 信号量
     */
    public static volatile int i = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                if (i ==0){
                    for (int j = 0;j<5;j++){
                        System.out.println("a");
                    }
                    i = 1;
                    break;
                }
            }
        });

        Thread thread1 = new Thread(()->{
            while (true){
                if (i ==1){
                    for (int j = 0;j<5;j++){
                        System.out.println("b");
                    }
                    i = 0;
                    break;
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
