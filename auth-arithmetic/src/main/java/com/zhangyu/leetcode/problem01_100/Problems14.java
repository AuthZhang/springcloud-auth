package com.zhangyu.leetcode.problem01_100;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

import org.springframework.util.StopWatch;

import java.util.*;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:27 下午
 */
public class Problems14 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        String[] strings = new String[]{"ab","abcdef","abcd","abc"};
        stopWatch.start();
        System.out.println(getCommonPrefix(strings));
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeNanos());
        System.out.println("======");
        stopWatch.start();
        System.out.println(getCommonPrefix1(strings));
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeNanos());
    }

    /**
     * @description:
     *
     * 正向，递增的比较
     *
     * 解答成功:
     * 				执行耗时:7 ms,击败了12.12% 的Java用户
     * 				内存消耗:36.6 MB,击败了57.41% 的Java用户
     *
     * @author: zhangyu122
     * @date: 2020/12/31 5:57 下午
     */
    private static  String getCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1){
            return strs[0];
        }
        Map<Integer,Integer> indexLength = new HashMap<>();
        Set<Integer> lengths = new TreeSet<>();
        for (int i = 0; i< strs.length ; i++){
            int length = strs[i].length();
            lengths.add(length);
            indexLength.put(length,i);
        }
        Integer minLength = lengths.stream().findFirst().get();
        Integer index = indexLength.get(minLength);
        String minLengthItm = strs[index.intValue()];
        String result = "";
        for (int i = 1;i <= minLength ;i ++){
            result = minLengthItm.substring(0, i);
            for (int j = 0; j< strs.length ; j++){
                String item  = strs[j];
                if (!item.startsWith(result)){
                    return minLengthItm.substring(0, i-1);
                }
            }
        }
        return result;
    }


    /**
     * @description:
     * 逆向，递减的去比较
     *              解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.7 MB,击败了42.21% 的Java用户
     * @author: zhangyu122
     * @date: 2020/12/31 6:40 下午
     */
    private static  String getCommonPrefix1(String[] strs){
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1){
            return strs[0];
        }
        String a = strs[0];
        for (String item : strs){
            if ("".equals(a)) return a;
            while (!item.startsWith(a)){
                a = a.substring(0,a.length() -1);
            }
        }
        return a;
    }

}
