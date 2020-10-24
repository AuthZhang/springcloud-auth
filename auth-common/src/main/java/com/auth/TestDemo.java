package com.auth;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestDemo {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 9};
        HashMap<Integer, Integer> integerIntegerHashMap = get1(a, 7);
        System.out.println();

    }

    /**
     * 两层for循环，时间复杂度O(N)
     *
     * @param a
     * @param param
     * @return
     */
    public static HashMap<Integer, Integer> get(int[] a, int param) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if ((a[i] + a[j]) == param) {
                    result.put(i, j);
                }
            }
        }
        return result;
    }

    public static HashMap<Integer, Integer> get1(int[] a, int param) {
        HashMap<Integer, Integer> result = new HashMap<>();
        List<Integer> integers = Ints.asList(a);
        for (Integer integer : integers){
            int i = param-integer.intValue();
            if (i > 0 && integers.contains(i)){
                int i1 = integers.indexOf(i);
                int i2 = integers.indexOf(integer);
                if (result.containsValue(i2)){
                    continue;
                }
                result.put(i2, i1);
            }
        }
        return result;
    }

}
