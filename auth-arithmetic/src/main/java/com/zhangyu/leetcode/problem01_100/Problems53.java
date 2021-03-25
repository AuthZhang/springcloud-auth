package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/16 2:14 下午
 */
@Slf4j
public class Problems53 {

    /**
     *
     *
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/16 2:58 下午
     */
    public static int maxSubArray(int[] nums) {
        // 最大连续子序和-最后一个被添加的元素
        int pre = 0;
        // 最大连续子序和
        int max = nums[0];
        for (int x : nums){
            pre  = Math.max(pre + x , x);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));


    }

}
