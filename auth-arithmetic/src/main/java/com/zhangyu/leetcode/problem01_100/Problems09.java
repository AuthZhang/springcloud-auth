package com.zhangyu.leetcode.problem01_100;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:26 下午
 */
public class Problems09 {

    public static void main(String[] args) {
        System.out.println(isPalindrome1(1001));
    }

    /**
     * @description:
     * 将整数转为字符串来解决
     *
     * 解答成功:
     * 				执行耗时:10 ms,击败了71.27% 的Java用户
     * 				内存消耗:37.8 MB,击败了67.48% 的Java用户
     * @author: zhangyu122
     * @date: 2021/7/5 5:08 下午
     */
    public static boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        if (s.startsWith("-")){
            return false;
        }
        int startIndex = 0;
        int length = s.length();
        int endIndex = length-1;
        int middle = length % 2 ==0 ? (length >> 1)-1 : length >> 1;
        while (startIndex < middle){
            char c = s.charAt(startIndex);
            char endChar = s.charAt(endIndex);
            if (c != endChar){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        if (length % 2 ==0 && middle+1<length){
            char c = s.charAt(middle);
            char endChar = s.charAt(middle+1);
            if (c != endChar){
                return false;
            }
        }

        return true;
    }

    /**
     * @description:
     * 执行耗时:9 ms,击败了99.44% 的Java用户
     * 内存消耗:37.9 MB,击败了77.87% 的Java用户
     * @author: zhangyu122
     * @date: 2020/11/30 8:07 下午
     */
    public static boolean isPalindrome(int x) {
        int r = x;
        if (x<0){
            return false;
        }
        if (x >Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return false;
        }
        long l = 0;
        while (x != 0){
            int t = x % 10;
            l = l*10 + t;
            x = x / 10;
        }
        int i = (int)l;
        return i == r;
    }
}
