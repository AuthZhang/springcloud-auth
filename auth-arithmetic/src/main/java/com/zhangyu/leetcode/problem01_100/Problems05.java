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

    public static void main(String[] args) throws Exception{
        String a = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(a.length());
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        System.out.println(longestPalindrome(a));
        stopwatch.stop();
        System.out.println(stopwatch.getLastTaskTimeMillis());
//        System.out.println(longestPalindrome("cbdabagdd"));

    }

    public static String longestPalindrome(String s) {
        if (isPalindrome(s)){
            return s;
        }
        Map<String,Integer> scenMap = new HashMap();
        return longestPalindrome3(s,scenMap);
    }

    public static String longestPalindrome3(String s,Map<String,Integer> set){
        if (s == null || s.length() == 0){
            return "";
        }
        int length = s.length();
        String substring = s.substring(length>2?2:1);
        if (isPalindrome(substring)){
            return substring;
        }
        String v1 = "";
        if (!set.containsKey(substring)){
            set.put(substring,null);
            v1 = longestPalindrome3(substring,set);
        }
        String substring1 = s.substring(0, s.length()-(length>2?2:1));
        if (isPalindrome(substring1)){
            return substring1;
        }
        String v2 = "";
        if (!set.containsKey(substring1)){
            set.put(substring1,null);
            v2 = longestPalindrome3(substring1,set);
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


}
