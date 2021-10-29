package com.zhangyu.single;

public class SingleDemo {

    private static volatile SingleDemo singleDemo;

    /**
     * @Author zhangyu
     * @Description double check lock
     * 双重校验同步锁
     * @Date 18:23 2021/10/17
     */
    public static SingleDemo getInstance(){
        if (singleDemo == null){
            synchronized(SingleDemo.class){
                if (singleDemo == null){
                    singleDemo = new SingleDemo();
                }
            }
        }
        return singleDemo;
    }
}
