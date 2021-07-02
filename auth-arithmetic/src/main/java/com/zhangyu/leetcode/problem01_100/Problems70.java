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

        System.out.println(climbStairs2(4));
        System.out.println(climbStairs2(5));
        System.out.println(climbStairs2(6));
        System.out.println(climbStairs2(7));
        System.out.println(climbStairs2(8));
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
        return climbStairs(n-1) + climbStairs(n-2) ;
    }
    
    /**
     * @description:
     * 一次最多可以迈2个台阶
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35.2 MB,击败了45.56% 的Java用户
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

    /**
     * @description:
     * 一次最多可以迈3个台阶
     * @author: zhangyu122
     * @date: 2021/7/2 6:02 下午
     */
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 4;
        int temp = 0;
        for (int i = 4; i <= n; i++) {
            temp = a + b +c ;
            a = b;
            b = c;
            c = temp;
        }
        return temp;
    }

}
