package com.zhangyu.arithmetic.hashMapExercise;

import java.util.HashMap;

public class HashMapExercise {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",1);
        System.out.println(map);
        HashMap<String,Integer> map1 = new HashMap<>(15);

        System.out.println(hash("种地") & 15);
        System.out.println(hash("通话")& 15);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
