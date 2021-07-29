package com.zhangyu.leetcode.problem201_300;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/7/28 7:20 下午
 */
@Slf4j
public class Problems300 {

    public static void main(String[] args) {
        int[] p = new int[]{0,1,0,3,2,3};
        // [2,3,7,101]
        System.out.println(lengthOfLIS(p));
    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:72 ms,击败了53.83% 的Java用户
     * 				内存消耗:38 MB,击败了61.18% 的Java用户
     * @author: zhangyu122
     * @date: 2021/7/29 2:49 下午
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int result = 1;
        int[] indexLength = new int[nums.length];
        indexLength[0] = 1;
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j<=i;j++){
                if (nums[i] > nums[j]){
                    indexLength[i] = Math.max(indexLength[j] +1,indexLength[i]);
                    result = Math.max(result,indexLength[i] );
                }else {
                    indexLength[i] = Math.max(1,indexLength[i]);
                }
            }
        }
        return result;
    }

}
