package com.zhangyu.thread.bosszhipin;

import java.util.Arrays;
import java.util.List;

public class ZiruDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "bcd");
        print(strings);
    }

    public static void print(List<String> arg){
        arg.stream().forEach(item->{
            if (item.contains("a")){
                System.out.println(item);
            }
        });
    }
}
