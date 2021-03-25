package com.zhangyu.leetcode.problem01_100;


/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/2 3:36 下午
 */
public class Problems27 {

    /**
     * 					解答成功:
     * 					执行耗时:0 ms,击败了100.00% 的Java用户
     * 					内存消耗:37.1 MB,击败了40.64% 的Java用户
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/3 10:18 上午
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int n = 0;
        while (n < nums.length){
            if (nums[p] == val){
                if (n+1 == nums.length) break;
                if (nums[n+1] == val){
                    n++;
                    continue;
                }else {
                    nums[p] = nums[n+1];
                    nums[n+1] = val;
                }
            }else {
                p++;
                n++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] param = new int[]{2};
        int i1 = removeElement(param,3);
        System.out.println("结果："+i1);
        for (int i = 0 ; i<i1 ;i++){
            System.out.print(param[i]);
        }
        System.out.println();
    }

}
