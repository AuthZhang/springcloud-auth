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

//    public static void main(String[] args) {
//        int a[] = new int[]{4, 6, 2, 3, 7, 1};
//        bubblingSort(a);
//        log.info("result : {}", Arrays.toString(a));
//    }

    /**
     * 快速排序
     *
     * @param arrays
     * @param left
     * @param right
     */
    public static void quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            int i, j, x;
            i = left;
            j = right;
            x = arrays[i];
            while (i < j) {
                /**
                 * 从右向左找第一个小于x的值
                 */
                while (i < j && arrays[j] >= x) {
                    j--;
                }
                //如果此时i仍小于j，则将 j位置的数据赋值给i位置
                if (i < j) {
                    arrays[i] = arrays[j];
                }
                /**
                 * 从左向右找第一个大于x的值
                 */
                while (i < j && arrays[i] <= x) {
                    i++;
                }
                if (i < j) {
                    arrays[j] = arrays[i];
                }
            }
            //将一开始选定的中轴值置为中间位置
            arrays[i] = x;
            quickSort(arrays, left, i - 1);
            quickSort(arrays, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{2,9,4,5,7,6};
        quickSort(a,0,a.length-1);
        log.info("result : {}", Arrays.toString(a));
    }

}
