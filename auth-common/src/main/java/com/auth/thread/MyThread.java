package com.auth.thread;

public class MyThread extends Thread {


    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("my thread");
    }

}
