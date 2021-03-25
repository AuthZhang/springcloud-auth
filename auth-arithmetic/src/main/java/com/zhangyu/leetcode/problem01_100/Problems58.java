package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/24 5:17 下午
 */
@Slf4j
public class Problems58 {

    public static int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String[] s1 = s.split(" ");
        if (s1.length == 0) return 0;
        return s1[s1.length-1].length();
    }

    public static void main(String[] args) {

    }

}
