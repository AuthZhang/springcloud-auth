package com.auth.bean.load;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class B extends A {

    static {
        log.info("B class static info");
    }

    {
        log.info("B class code ");
    }


    public B() {
        log.info("B class constructor");
    }


}
