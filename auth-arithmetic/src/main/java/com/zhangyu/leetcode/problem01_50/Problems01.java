package com.zhangyu.leetcode.problem01_50;

import com.alibaba.fastjson.JSONObject;
import com.google.common.primitives.Ints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:23 下午
 */
public class Problems01 {

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        /**
         * key:存储数组中的元素值
         * value：存储元素的下标
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.keySet().contains(a)) {
                result[0] = map.get(a);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 两层for循环，时间复杂度O(N)
     *
     * @param a
     * @param param
     * @return
     */
    public static HashMap<Integer, Integer> get(int[] a, int param) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if ((a[i] + a[j]) == param) {
                    result.put(i, j);
                }
            }
        }
        return result;
    }


    /**
     * @description:
     *
     * @author: zhangyu122
     * @date: 2020/12/11 11:18 上午
     */
    public static HashMap<Integer, Integer> get1(int[] a, int param) {
        //结果集
        HashMap<Integer, Integer> result = new HashMap<>();
        //数据池
        List<Integer> integers = Ints.asList(a);
        for (Integer integer : integers){
            //逆向思维用减法
            int i = param-integer.intValue();
            if (i > 0 && integers.contains(i)){
                int i1 = integers.indexOf(i);
                int i2 = integers.indexOf(integer);
                if (result.containsValue(i2)){
                    continue;
                }
                result.put(i2, i1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 9};
        HashMap<Integer, Integer> integerIntegerHashMap = get1(a, 7);
        System.out.println(JSONObject.toJSONString(integerIntegerHashMap));

    }

}
