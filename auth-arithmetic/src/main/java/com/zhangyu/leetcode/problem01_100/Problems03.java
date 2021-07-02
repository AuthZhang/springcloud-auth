package com.zhangyu.leetcode.problem01_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/7/2 3:42 下午
 */
public class Problems03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("bbbbb"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("au"));

    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int start=0,end = 0; end<s.length(); end++){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(map.get(c),start);
            }
            result = Math.max(result,end-start+1);
            map.put(c,end+1);
        }
        return result;
    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:6 ms,击败了86.40% 的Java用户
     * 				内存消耗:38.4 MB,击败了71.71% 的Java用户
     * @author: zhangyu122
     * @date: 2021/7/2 5:11 下午
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int result = 0;
        int start = 0;
        int end = 1;
        for (int i = 0;i<s.length();i++){
            String substring = s.substring(start, i);
            int length = substring.length();
            char c = s.charAt(i);
            if (substring.contains(String.valueOf(c))){
                result = length >= result ? length : result;
                int i1 = substring.indexOf(c);
                start = start+i1+1;
                end = i;
            }
            end++;
        }
        int i = end>=s.length()? s.length() - start : end-start;
        return i>result ? i : result;
    }


}
