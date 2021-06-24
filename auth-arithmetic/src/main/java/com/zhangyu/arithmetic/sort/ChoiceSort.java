package com.zhangyu.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 选择排序
 * 相比较冒泡排序，减少了交换次数
 */
@Slf4j
public class ChoiceSort {

    /**
     *
     * @param params
     */
    public static void choiceSort(int[] params) {
        int baseIndex = 0;
        int temp = 0;
        for (int i = 0; i < params.length - 1; i++) {
            baseIndex = i;
            for (int j = i; j < params.length; j++) {
                if (params[j] < params[baseIndex]) {
                    baseIndex = j;
                }
            }
            temp = params[i];
            params[i] = params[baseIndex];
            params[baseIndex] = temp;
        }

    }

    public static void main(String[] args) {
        int a[] = new int[]{4, 6, 2, 3, 7, 1};
        System.out.println(a.length);
        choiceSort(a);
        log.info("result : {}", Arrays.toString(a));
    }

}
