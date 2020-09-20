package com.auth.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MyCallable implements Callable<Integer> {

    public static int i = 0;

    @Override
    public Integer call() throws Exception {
        ++i;
        log.info("current thread name : {} , i : {}" ,Thread.currentThread().getName(),i);
        return i;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(new MyRunnable());
        List<MyCallable> myCallables = new ArrayList<MyCallable>();
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        myCallables.add(new MyCallable());
        List<Future<Integer>> futures = executorService.invokeAll(myCallables);
        log.info("last future : {}",futures.get(0).get());
        executorService.shutdown();
    }
}
