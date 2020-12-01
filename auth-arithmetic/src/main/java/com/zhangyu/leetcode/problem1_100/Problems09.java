package com.zhangyu.leetcode.problem1_100;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:26 下午
 */
public class Problems09 {
    /**
     * @description:
     * 执行耗时:9 ms,击败了99.44% 的Java用户
     * 内存消耗:37.9 MB,击败了77.87% 的Java用户
     * @author: zhangyu122
     * @date: 2020/11/30 8:07 下午
     */
    public static boolean isPalindrome(int x) {
        int r = x;
        if (x<0){
            return false;
        }
        if (x >Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return false;
        }
        long l = 0;
        while (x != 0){
            int t = x % 10;
            l = l*10 + t;
            x = x / 10;
        }
        int i = (int)l;
        return i == r;
    }
}
