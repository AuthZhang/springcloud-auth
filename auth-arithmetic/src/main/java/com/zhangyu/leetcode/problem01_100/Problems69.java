package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/4/23 1:43 下午
 */
@Slf4j
public class Problems69 {

    
   
    public static void main(String[] args) {
        int i= 65533-32766;
        int i1 = i >>1;
        int i2 = i1 + 32766;
        System.out.println();

        System.out.println(mySqrt(2147395600));
    }

    /**
     * @description:
     *                                解答成功:
     * 				执行耗时:2 ms,击败了46.56% 的Java用户
     * 				内存消耗:35.6 MB,击败了47.91% 的Java用户
     * @author: zhangyu122
     * @date: 2021/4/23 3:17 下午
     */
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int middle = right >> 1;
        if (middle == 0){
            return x;
        }
        while (left<middle){
            if (middle == 32766){
                System.out.println();
            }
            double pow = Math.pow(middle, 2);
            double powPlus = Math.pow(middle+1, 2);
            if (pow < x){
                if (powPlus > x){
                    return middle;
                }
                left = middle;
                int i = ((right - left) >> 1) + left;
                middle = i;
            }else if (pow > x){
                right = middle;
                int i = ((right - left) >> 1) + left;
                middle = i;
            }else {
                return middle;
            }
        }
        return left;
    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:200 ms,击败了5.01% 的Java用户
     * 				内存消耗:35.5 MB,击败了70.59% 的Java用户
     * @author: zhangyu122
     * @date: '2021/4/23' 2:40 下午
     */
    public int mySqrt1(int x) {
        for (int i = 0 ;i <= x ;i++){
            if (Math.pow(i,2) <= x && Math.pow((i+1),2) > x){
                return i;
            }
        }
        return 0;
    }


}
