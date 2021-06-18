package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

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

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        Map<Integer,Integer> nums2Map = new HashMap<>(n);
        for (int i =0;i<n;i++){
            int i1 = nums2[i];
            nums2Map.put(i1,i);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = nums2Map.entrySet().iterator();
        for (int i = 0 ;i<m && iterator.hasNext();i++){
            int i1 = nums1[i];
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer j1 = next.getKey();
                if (i1 == j1){

                    for (int h = i;h<m;h++){

                    }

                }else if (i1<j1){

                } else if (i1>j1) {

                }
                iterator.remove();
            }
        }
    }

}
