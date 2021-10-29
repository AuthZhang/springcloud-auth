package com.zhangyu.thread.printABC.way1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * Created by zhangyu on 2018/9/6.
 */

public class TestMain {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        PrintLetter printLetter = new PrintLetter();

        /**
         *   创建三个线程，每个线程都独自维护自己的letter，只有当单例对象PrintLetter中的letter和自己的letter相同时才打印，
         *   否则等待，
         *
         * @author zhangyu
         * @date 2018/9/6
         */
        executorService.execute(new PrintLetterRunnable(printLetter,'A'));
        executorService.execute(new PrintLetterRunnable(printLetter,'B'));
        executorService.execute(new PrintLetterRunnable(printLetter,'C'));

        executorService.shutdown();
    }
}
