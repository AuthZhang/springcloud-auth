package com.zhangyu.thread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {

        /**
         * 全部任务到达栅栏出需要执行的任务
         */
        travel();
    }

    public static void travel(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());
        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new TravelTask(cyclicBarrier,"哈登",10));
        executor.execute(new TravelTask(cyclicBarrier,"保罗",3));
        executor.execute(new TravelTask(cyclicBarrier,"戈登",1));
        /**
         * 导游休息一晚上，第二天继续接待旅客
         */
        cyclicBarrier.reset();
        executor.execute(new TravelTask(cyclicBarrier,"安娜",3));
        executor.execute(new TravelTask(cyclicBarrier,"婕拉",1));
        executor.execute(new TravelTask(cyclicBarrier,"索菲亚",1));
    }

}
