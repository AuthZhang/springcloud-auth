package com.auth.genericity;

public class Test {

    /**
     * 类型参数
     *
     *
     * @param array
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T findMax(T[] array,T t){
        for (T tArray : array) {
            if (tArray.equals(t)){
                return tArray;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = {"a","b"};
        System.out.println(findMax(a,"c"));
    }
}
