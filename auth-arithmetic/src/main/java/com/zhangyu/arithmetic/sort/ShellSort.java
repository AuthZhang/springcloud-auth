package com.zhangyu.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 希尔排序
 * 基于插入排序，增加了一些特性，提高插入排序的效率
 * 优点：
 *  插入排序的缺点是数据的多次移动，而希尔排序通过加大插入排序中元素的间隔，来对这些元素进行插入排序，也就是加大了数据移动的步伐，并逐步缩短步伐进行调整，
 *  希尔排序基本可以保证右边不会有太小的数据，避免了大面积的数据移动
 * 间隔计算：
 *  H = 3* H +1 ,H的初始值是1，该间隔大于数组大小时停止
 *  缩短间隔：H =(H -1)/3
 *
 */
@Slf4j
public class ShellSort {

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
