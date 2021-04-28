package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/4/27 5:27 下午
 */
@Slf4j
public class Problems70 {

    
   
    public static void main(String[] args) {

        System.out.println(climbStairs(45));
    }

    /**
     * @description:
     * 时间复杂度太高
     * 存在重复计算问题
     * 比如计算F(10)时，需要计算F(9)和F(8)，可曾想过当计算F(9)时又计算了一遍F(8)
     * @author: zhangyu122
     * @date: 2021/4/27 5:17 下午
     */
    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n ==2 ){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
    
    /**
     * @description:
     * @author: zhangyu122
     * @date: 2021/4/27 5:18 下午
     */
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }



}
