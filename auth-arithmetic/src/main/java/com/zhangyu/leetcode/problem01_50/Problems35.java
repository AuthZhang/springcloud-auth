package com.zhangyu.leetcode.problem01_50;


/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/8 3:48 下午
 */
public class Problems35 {

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:37.8 MB,击败了98.74% 的Java用户
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/8 4:37 下午
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[0] > target) return 0;
        if (nums[nums.length-1] <  target) return nums.length;
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int middle = ((end-start) >> 1) + start;
            if (nums[middle] == target){
                return middle == 0 ? 0 : middle;
            }else if (nums[middle] > target){
                if (middle-1 >= 0 && nums[middle-1] < target){
                    return middle;
                }
                end = middle -1;
            }else {
                if (middle+1 < nums.length && nums[middle+1] > target){
                    return middle+1;
                }
                start = middle+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3},3));
    }

}
