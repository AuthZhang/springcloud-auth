package com.zhangyu.leetcode.problem01_100;


/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/8 3:48 下午
 */
public class Problems28 {

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了71.29% 的Java用户
     * 				内存消耗:38.7 MB,击败了8.48% 的Java用户
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/8 4:12 下午
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (haystack.length() == 0 ){
            if (needle.length() == 0) {
                return 0;
            }else return -1;
        }else {
            if (needle.length() == 0) {
                return 0;
            }else if (needle.length() > haystack.length()) return -1;
        }
        char c = needle.charAt(0);
        int needleLengh = needle.length();
        for (int i = 0 ; i < haystack.length() ; i++){
            char c1 = haystack.charAt(i);
            if (c1 != c) continue;
            int i1 = i + needleLengh;
            if (i1 > haystack.length()) return -1;
            CharSequence charSequence = haystack.subSequence(i, i1);
            if (charSequence.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hystack = "hello";
        String needle = "ll";
        System.out.println(strStr(hystack,needle));
    }

}
