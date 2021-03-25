package com.zhangyu.leetcode.problem01_100;


/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/2 3:36 下午
 */
public class Problems26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0;
        int next = 1;
        while (next < nums.length){
            if (nums[pre] != nums[next]){
                nums[pre+1] = nums[next];
                pre++;
            }
            next++;
        }
        return pre+1;
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:40.4 MB,击败了40.49% 的Java用户
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/2 5:53 下午
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0;
        int next = 1;
        while (next < nums.length){
            if (nums[pre] != nums[next]){
                nums[pre+1] = nums[next];
                pre++;
            }
            next++;
        }
        return pre+1;
    }
    /**
     * 解答成功:
     * 				执行耗时:48 ms,击败了5.83% 的Java用户
     * 				内存消耗:40 MB,击败了92.92% 的Java用户
     *
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/2 5:06 下午
     */
    public static int removeDuplicates1(int[] nums) {
        int result = 1;
        for (int i = 0 ;i< nums.length;i++){
            int num = nums[i];
            out:for (int j = i ; j<nums.length;j++){
                int val = nums[j];
                if (val <= num){
                    continue;
                }
                nums[i+1] = val;
                result++;
                break out;
            }
            if (nums[i] == nums[nums.length-1]){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] param = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i1 = removeDuplicates(param);
        System.out.println("结果："+i1);
        for (int i = 0 ; i<i1 ;i++){
            System.out.print(param[i]);
        }
        System.out.println();
    }

}
