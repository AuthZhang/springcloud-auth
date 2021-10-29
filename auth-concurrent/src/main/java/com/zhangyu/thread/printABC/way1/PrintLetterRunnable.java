package com.zhangyu.thread.printABC.way1;
/**
 * 
 * Created by zhangyu on 2018/9/6.
 */

public class PrintLetterRunnable implements Runnable {
    //维护一个PrintLetter对象，单例的
    private PrintLetter printLetter = null;

    /**
     *   线程内独自维护的letter
     *   该对象用于和内存中单例对象PrintLetter内的letter进行比较
     * @author zhangyu
     * @date 2018/9/6
     */
    private char letter = ' ';

    public PrintLetterRunnable(PrintLetter printLetter,char letter) {
        this.printLetter = printLetter;
        this.letter =letter;
    }

    @Override
    public void run() {
        //10次循环，每次循环打印一次ABC
        for (int i = 0; i<10 ;i++){
            //给PrintLetter对象加锁
            synchronized (printLetter){
                //加锁后，如果发现此时内存中PrintLetter对象的letter和自己的letter不同，则等待
                if (printLetter.getLetter() != this.letter){
                    try {
                        printLetter.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                printLetter.printLetter();
                printLetter.nextChar();
                //唤醒等待线程，竞争printLetter对象的锁
                printLetter.notifyAll();
            }
        }

    }
}
