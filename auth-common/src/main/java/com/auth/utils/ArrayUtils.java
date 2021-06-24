package com.auth.utils;
/**
 * 
 * Created by zhangyu on 2018/6/29.
 */

public class ArrayUtils {


    /*
     *   二分查找
     *   前提是该数组为一个已经排好序的数组
     * @author zhangyu
     * @date 2018/6/29
     */
    public static int halfSearch(int[] srcArray,int targetParameter){
        int low = 0;
        int high = srcArray.length - 1;//数组下标从0开始，防止下标越界
        while (low <= high){
            int middle = (low + high) >> 1;//这里右移一位位运算和/2是一样的效果
            if (targetParameter == srcArray[middle]){
                return srcArray[middle];
            }else if (targetParameter < srcArray[middle]){
                high = middle - 1;
            }else if (targetParameter > srcArray[middle]){
                low = middle + 1;
            }
        }
        return -1;
    }

    /*
     *   给定一个数组，取出该数组中第二大的数值
     *   只能用一个循环
     * @author zhangyu
     * @date 2018/7/18
     */
    public int findSecMax(int[] data) {
        int maxNum = 0;
        int secMaxNum = 0;
        // 先将前两个元素按大小分别赋给第一大和第二大的数
        if (data.length < 2)
            return -1;
        if (data[0] >= data[1]) {
            maxNum = data[0];
            secMaxNum = data[1];
        } else {
            maxNum = data[1];
            secMaxNum = data[0];
        }
        // 从第三个开始循环，如果元素大于最大值，则最大值更新，原最大值赋给第二大值
        // 如果该元素不大于最大值，且大约第二大的值，则第二大的值更新
        for (int i = 2; i < data.length; i++) {
            if (data[i] > maxNum) {
                secMaxNum = maxNum;
                maxNum = data[i];
            } else {
                if (data[i] >= secMaxNum) {
                    secMaxNum = data[i];
                }
            }
        }
        return secMaxNum;
    }

    public static int getData(int n){
        if (n > 0){
            return n;
        }else {
            return getData(n+1);
        }
    }


}
