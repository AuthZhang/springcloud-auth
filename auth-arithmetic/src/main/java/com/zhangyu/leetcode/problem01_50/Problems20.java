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

import java.util.*;

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
     *              解答成功:
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

    /**
     * @description:
     *
     *              解答成功:
     * 				执行耗时:3 ms,击败了25.36% 的Java用户
     * 				内存消耗:36.6 MB,击败了57.05% 的Java用户
     *
     * @author: zhangyu122
     * @date: 2021/2/2 5:31 下午
     */
    private static boolean check1(String s){
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character,Character> map =new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0 ;i < s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                Character peek = stack.peek();
                Character character = map.get(peek);
                if (!character.equals(c)){
                    return false;
                }
                stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
