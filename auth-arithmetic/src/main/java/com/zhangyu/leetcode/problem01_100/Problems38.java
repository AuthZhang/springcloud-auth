package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/11 3:12 下午
 */
@Slf4j
public class Problems38 {

    /**
     * @description:
     *                                解答成功:
     * 				执行耗时:9 ms,击败了32.86% 的Java用户
     * 				内存消耗:36.3 MB,击败了40.61% 的Java用户
     * @author: zhangyu122
     * @date: 2021/3/11 3:52 下午
     */
    public static String countAndSay1(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 0;
        char[] chars = s.toCharArray();
        char tempChar = chars[0];
        if (chars.length == 1) return "1"+tempChar;
        for (int i = 0 ; i < chars.length ; i++){
            if (chars[i] == tempChar){
                ++count;
                if ( i+1 == chars.length){
                    result.append(count).append(tempChar);
                }
            }else {
                result.append(count).append(tempChar);
                count = 1;
                tempChar = chars[i];
                if ( i+1 == chars.length){
                    result.append(count).append(tempChar);
                }
            }
        }
        return result.toString();

    }

    /**
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/11 4:06 下午
     */
    public static String countAndSay2(int n) {
        if(n==1)  //递归第一件事, 递归结束条件
            return "1";
        String str = countAndSay(n-1); //上一轮的输出是是下一轮的输入
        StringBuffer ans = new StringBuffer(); //存放当前轮答案, 要用StringBuffer, String如果改变, 底层是复制效率很低
        int len = str.length();
        int start = 0; //记录开始下标
        for(int i=1;i<len+1;i++){
            if(i==len) //最后一个元素单独处理
                ans.append(i - start).append(str.charAt(start));
            else if(str.charAt(i) != str.charAt(start)){  //元素改变触发函数
                ans.append(i - start).append(str.charAt(start));
                start = i; //更新起始下标
            }
        }
        return ans.toString(); //StringBuffer记得要转化为String类型
    }


    /**
     * @description:
     *                                解答成功:
     * 				执行耗时:22 ms,击败了16.89% 的Java用户
     * 				内存消耗:39.2 MB,击败了5.06% 的Java用户
     * @author: zhangyu122
     * @date: 2021/3/11 3:43 下午
     */
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        String result = "";
        int count = 0;
        char[] chars = s.toCharArray();
        char tempChar = chars[0];
        if (chars.length == 1) return "1"+tempChar;
        for (int i = 0 ; i < chars.length ; i++){
            if (chars[i] == tempChar){
                ++count;
                if ( i+1 == chars.length){
                    result = result+count+tempChar;
                }
            }else {
                result = result+count+tempChar;
                count = 1;
                tempChar = chars[i];
                if ( i+1 == chars.length){
                    result = result+count+tempChar;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        log.info("done");
        System.out.println(countAndSay(50));
        log.info("done");
        System.out.println(countAndSay1(50));
        log.info("done");

    }

}
