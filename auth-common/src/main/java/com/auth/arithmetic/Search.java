package com.auth.arithmetic;

import lombok.extern.slf4j.Slf4j;

/**
 * 查找
 */
@Slf4j
public class Search {

    /**
     * 二分查找、折半查找
     *
     * <p>
     * 实现查找指定数值在元素有序的数组中存储的位置（索引），返回该位置（索引）
     *
     * @param params
     * @param targert
     * @return
     */
    public static int halSearch(int[] params, int targert) {
        int min = 0;
        int max = params.length - 1;
        while (min < max) {
            int middle = (min + max) >> 1;
            if (params[middle] == targert) {
                return middle;
            } else if (params[middle] < targert) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(halSearch(a, 9));
    }
}
