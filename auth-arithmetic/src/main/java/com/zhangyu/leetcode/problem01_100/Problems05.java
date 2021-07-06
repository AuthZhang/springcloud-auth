package com.zhangyu.leetcode.problem01_100;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/7/5 4:28 下午
 */
public class Problems05 {

    /**
     * @description:
     * 从中间向两边找回文数
     * @author: zhangyu122
     * @date: 2021/7/6 11:26 上午
     */
    public static String longestPalindrome4(String s){
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            String s1 = palindrome(s, i, i);
            // 偶数
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    /**
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception{
//        String a = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        System.out.println(a.length());
//        StopWatch stopwatch = new StopWatch();
//        stopwatch.start();
//        System.out.println(longestPalindrome(a));
//        stopwatch.stop();
//        System.out.println(stopwatch.getLastTaskTimeMillis());
//        System.out.println(longestPalindrome("cbdabagdd"));


        System.out.println("zhangyu".getBytes());

    }

    public static String longestPalindrome(String s) {
        if (isPalindrome1(s)){
            return s;
        }
        Map<String,Integer> scenMap = new HashMap();
        return longestPalindrome3(s,scenMap,s.length());
    }

    public static String longestPalindrome3(String s,Map<String,Integer> set,int max){
        if (s == null || s.length() == 0){
            return "";
        }
        String substring = s.substring(1);
        if (isPalindrome1(substring)){
            return substring;
        }
        String v1 = "";
        if (!set.containsKey(substring)){
            set.put(substring,null);
            v1 = longestPalindrome3(substring,set,max);
        }
        max = v1.length();
        String substring1 = s.substring(0, s.length()-1);
        if (isPalindrome1(substring1)){
            return substring1;
        }
        if (substring1.length() < max){
            return "";
        }
        String v2 = "";
        if (!set.containsKey(substring1)){
            set.put(substring1,null);
            v2 = longestPalindrome3(substring1,set,max);
        }
        return v1.length()>v2.length() ? v1 : v2;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        StringBuilder reverse = new StringBuilder(s).reverse();
        return  reverse.toString().equals(s);

    }

    /**
     * *************************************************************************************************************
     */
    /**
     * @description:
     * 第一种方式
     * @author: zhangyu122
     * @date: 2021/7/5 7:25 下午
     */
    public static String longestPalindrome1(String s) {
        if (isPalindrome1(s)){
            return s;
        }
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> scenMap = new HashMap();
        longestPalindrome2(s,map,scenMap);
        String result = "";
        int max = 0;
        for (String key:map.keySet()){
            Integer integer = map.get(key);
            if (integer < max){
                continue;
            }
            result = key;
            max = integer;
        }
        return result;
    }

    public static void longestPalindrome2(String s,Map<String,Integer> map,Map<String,Integer> set){
        if (s == null || s.length() == 0){
            return;
        }
        if (isPalindrome1(s)){
            map.put(s,s.length());
            return ;
        }
        String substring = s.substring(1);
        if (!set.containsKey(substring)){
            set.put(substring,null);
            longestPalindrome2(substring,map,set);
        }
        String substring1 = s.substring(0, s.length()-1);
        if (!set.containsKey(substring1)){
            set.put(substring1,null);
            longestPalindrome2(substring1,map,set);
        }
    }

    public static boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        int startIndex = 0;
        int length = s.length();
        int endIndex = length-1;
        boolean b = length % 2 == 0;
        int middle = b ? (length >> 1)-1 : length >> 1;
        while (startIndex < middle){
            char c = s.charAt(startIndex);
            char endChar = s.charAt(endIndex);
            if (c != endChar){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        if (b && middle+1<length){
            char c = s.charAt(middle);
            char endChar = s.charAt(middle+1);
            if (c != endChar){
                return false;
            }
        }
        return true;
    }


}
