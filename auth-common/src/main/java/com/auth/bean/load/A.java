package com.auth.bean.load;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A {

    static {
        log.info("A class static info");
    }

    {
        log.info("A class code ");
    }


    public A() {
        log.info("A class constructor");
    }

    /**
     * 子父类加载顺序：
     *
     * 1、父类静态代码块
     * 2、子类静态代码块
     * 3、父类代码块
     * 4、父类构造器
     * 5、子类代码块
     * 6、子类构造器
     *
     * 双亲委派模型
     * 总是先让父类加载相关内容
     *
     * @param args
     */
    public static void main(String[] args) {
        A a = new B();
        a = new B();
    }
}
