package com.zhangyu.thread.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TourGuideTask implements Runnable{

    @Override
    public void run() {
        log.info("****最后一个线程{}完成任务：收集护照交给导游****",Thread.currentThread().getName());
        try {
            //模拟发护照签证需要2秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("InterruptedException : ",e);
        }
    }
}