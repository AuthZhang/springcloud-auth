package com.zhangyu.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 插入排序
 */
@Slf4j
public class InsertSort {

    /**
     * @description:
     * @author: zhangyu122
     * @date: 2021/6/25 3:31 下午
     */
    public static void insertSort(int[] params) {
        int temp = 0;
        for (int i = 1; i < params.length; i++) {
            //temp始终作为被比较值
            temp = params[i];
            int j = i;
            while (j>0 && params[j-1]>temp){
                params[j] = params[j-1];
                j--;
            }
            // 将被比较值放到正确位置
            params[j] =temp;
            log.info("result : {}", Arrays.toString(params));
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,4, 6, 2, 3, 7, 1};
        System.out.println(a.length);
        insertSort(a);
        log.info("result : {}", Arrays.toString(a));
    }

}
