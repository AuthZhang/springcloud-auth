package com.zhangyu.leetcode.problem01_50;

import java.util.Stack;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:24 下午
 */
public class Problems07 {
    /**
     * @description:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了97.97% 的Java用户
     * @author: zhangyu122
     * @date: 2020/11/30 5:12 下午
     */
    public static int reverse(int x){
        long l = 0;
        while (x != 0){
            int t = x % 10;
            l = l*10 + t;
            x = x / 10;
        }
        return l >Integer.MAX_VALUE || l < Integer.MIN_VALUE ? 0 : (int)l;
    }

    /**
     * @description: 这个使用了String ，效率特别低！！！
     * 执行耗时:7 ms,击败了8.67% 的Java用户
     * 内存消耗:37.4 MB,击败了5.00% 的Java用户
     * @author: zhangyu122
     * @date: 2020/11/30 5:13 下午
     */
    public static int reverse1(int x){
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();;
        for (char c : chars) {
            stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        String s1 = stringBuilder.toString();
        if (s1.endsWith("-")){
            s1 = s1.substring(0,s1.length()-1);
            s1 = "-"+s1;
        }
        try {
            Integer integer = Integer.valueOf(s1);
            return integer.intValue();
        }catch (NumberFormatException numberFormatException){

        }
        return 0;
    }
}
