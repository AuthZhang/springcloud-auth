package com.zhangyu.thread.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class TravelTask implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String name;
    //赶到机场所需的时间
    private int arriveTime;

    public TravelTask(CyclicBarrier cyclicBarrier,String name,int arriveTime){
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.arriveTime = arriveTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(arriveTime * 1000);
            System.out.println(name +"到达集合点"+"线程名："+Thread.currentThread().getName());
            cyclicBarrier.await(7,TimeUnit.SECONDS);
            System.out.println(name +"开始旅行啦～～");
        }
        catch (TimeoutException e) {
            log.error("TimeoutException : ",e);
        }
        catch (InterruptedException e) {
            log.error("InterruptedException : ",e);
        } catch (BrokenBarrierException e) {
            /**
             * BrokenBarrierException 表示栅栏已经被破坏，破坏的原因可能是其中一个线程 await() 时被中断或者超时
             */
            log.error("超时 BrokenBarrierException : ",e);
            /**
             * 重置cyclicBarrier，重新执行任务
             */
            cyclicBarrier.reset();
            Test.travel();
        }
    }
}
