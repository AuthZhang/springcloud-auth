package com.zhangyu.leetcode.problem01_50;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2021/1/5 6:32 下午
 */
public class Problems20 {

    public static void main(String[] args) {
        System.out.println(check1("()[]{}"));
    }

    /**
     * 解答成功:
     * 				执行耗时:5 ms,击败了9.19% 的Java用户
     * 				内存消耗:38.5 MB,击败了7.65% 的Java用户
     * @description:
     * @author: zhangyu122
     * @date: 2021/1/6 9:59 上午
     */
    private static boolean check(String s){
        if (s == null) return false;
        if (s.length() == 0) return true;
        List<String> baseChar = new ArrayList<>();
        baseChar.add("()");
        baseChar.add("{}");
        baseChar.add("[]");
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < chars.length ; i++){
            char currentChar = chars[i];
            if (stack.isEmpty()){
                stack.push(currentChar);
                continue;
            }
            Character preItem = stack.pop();
            String currentString = preItem.toString()+String.valueOf(currentChar);
            if (!baseChar.contains(currentString)){
                stack.push(preItem);
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }

    // TODO: 2021/1/6 待优化 
    private static boolean check1(String s){
        if (s == null) return false;
        if (s.length() == 0) return true;
        List<String> baseChar = new ArrayList<>();
        baseChar.add("()");
        baseChar.add("{}");
        baseChar.add("[]");
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < chars.length ; i++){
            char currentChar = chars[i];
            if (stack.isEmpty()){
                stack.push(currentChar);
                continue;
            }
            Character preItem = stack.pop();
            String currentString = preItem.toString()+ currentChar;
            if (!currentString.equals("()") && !currentString.equals("{}") && !currentString.equals("[]")){
                stack.push(preItem);
                stack.push(currentChar);
            }
            if ((i > (chars.length / 2 +1)) && !stack.isEmpty()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
