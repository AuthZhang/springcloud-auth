package com.auth.arithmetic;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 排序
 */
@Slf4j
public class Sort {

    /**
     * 冒泡排序
     * 结果：第一层循环，每次循环结束，总是把最大的排到最后
     *
     * @param params
     */
    public static void bubblingSort(int[] params) {
        int temp = 0;
        for (int i = 0; i < params.length - 1; i++) {
            log.info("result : {}", Arrays.toString(params));
            /**
             * 第二层循环的功能：将 "0-倒数第i+1个" 这组数据中最大的排到最后
             */
            for (int j = 0; j < params.length - (i + 1); j++) {
                if (params[j] > params[j + 1]) {
                    temp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int a[] = new int[]{4, 6, 2, 3, 7, 1};
        bubblingSort(a);
        log.info("result : {}", Arrays.toString(a));
    }
}
