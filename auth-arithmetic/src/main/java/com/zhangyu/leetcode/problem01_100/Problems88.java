package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/6/18 7:11 下午
 */
@Slf4j
public class Problems88 {
    //输入：
    // nums1 = [1,2,3,0,0,0], m = 3,
    // nums2 = [2,5,6], n = 3
    //输出：[1,2,2,3,5,6]

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        merge(nums1,6,nums2,3);
//        log.info("result : {}", Arrays.toString(nums1));


        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};
        merge(nums1,6,nums2,3);
        log.info("result : {}", Arrays.toString(nums1));
    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:4 ms,击败了24.99% 的Java用户
     * 				内存消耗:38.5 MB,击败了53.99% 的Java用户
     * @author: zhangyu122
     * @date: 2021/6/25 2:44 下午
     */
    public static void mergeDoubleIndex(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null){
            return;
        }
        int p1 = m-1;
        int p2 = n-1;
        int index = m+n-1;
        while (p1>=0 && p2>=0){
            if (nums1[p1]>=nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
                index--;
            }else {
                nums1[index] = nums2[p2];
                p2--;
                index--;
            }
        }
        while (p2>=0){
            nums1[index] = nums2[p2];
            p2--;
            index--;
        }
    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:4 ms,击败了24.99% 的Java用户
     * 				内存消耗:38.5 MB,击败了53.99% 的Java用户
     * @author: zhangyu122
     * @date: 2021/6/25 2:44 下午
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0){
            for (int i = 0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        Map<Integer,Integer> nums2Map = new HashMap<>(n);
        for (int i =0;i<n;i++){
            nums2Map.put(i,nums2[i]);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = nums2Map.entrySet().iterator();
        for (int i = (m+n)-1 ;i>0;i--){
            while (nums1[i] ==0 && iterator.hasNext()){
                nums1[i] = iterator.next().getValue();
                iterator.remove();
            }
        }
        int temp = 0;
        for (int i = 1; i < (m+n); i++) {
            //temp始终作为被比较值，比他大的要放到当前位置
            temp = nums1[i];
            int j = i;
            /**
             * nums1[j]保持是最大的
             */
            while (j>0 && nums1[j-1]>temp){
                nums1[j] = nums1[j-1];
                j--;
            }
            nums1[j] = temp;
        }
    }

}
