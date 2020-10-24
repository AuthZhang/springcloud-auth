package com.auth.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 插入排序
 * 将后一个元素和当前元素依次比较，如果比当前元素大，则进行补位操作
 */
@Slf4j
public class InsertSort {

    /**
     *
     * @param params
     */
    public static void choiceSort(int[] params) {
        int temp = 0;
        for (int i = 1; i < params.length; i++) {
            //temp始终作为被比较值，比他大的要放到当前位置
            temp = params[i];
            int j = i;
            /**
             * params[j]保持是最大的
             */
            while (j>0 && params[j-1]>temp){
                params[j] = params[j-1];
                j--;
            }
            params[j] = temp;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{4, 6, 2, 3, 7, 1};
        System.out.println(a.length);
        choiceSort(a);
        log.info("result : {}", Arrays.toString(a));
    }

}
