package com.auth.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 快速排序
 */
@Slf4j
public class QuickSort {

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
