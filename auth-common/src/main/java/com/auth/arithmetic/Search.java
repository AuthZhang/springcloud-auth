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
     * <p>
     * 时间复杂度 logN
     *
     * @param params
     * @param targert
     * @return
     */
    public static int halSearch(int[] params, int targert) {
        int min = 0;
        int max = params.length - 1;
        while (min < max) {
            /**
             * 不使用下面两种计算中间值的原因是：
             * int middle = (min + max) / 2;
             * int middle = (min + max) >> 1;
             *
             * min+max 结果可能会超过int的最大值Integer.MAX_VALUE，而出现负数，middle为负数是没有意义的
             *
             */

            int middle = min + (max - min) >> 1;

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
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] b = new int[Integer.MAX_VALUE >> 1];
//        for (int i = 0; i < b.length; i++) {
//            b[i] = i;
//        }

//        System.out.println(halSearch(b, Integer.MAX_VALUE >> 1 - 1));

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = (a + b) / 2;
        System.out.println(c);
    }
}
