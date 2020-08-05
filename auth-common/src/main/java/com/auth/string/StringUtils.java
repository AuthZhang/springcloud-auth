package com.auth.string;

import java.util.Calendar;

public class StringUtils {

    /**
     * 递归反转字符串
     * 步进入参为：截取从第二位到结尾的字符串
     * 终止条件为：截取后的字符串长度为1
     *
     * @param param
     * @return
     */
    public static String invert(String param){
        if (param == null ){
            return null;
        }
        if (param.length() ==1){
            return param;
        }
        return invert(param.substring(1)) +param.charAt(0);
    }

    public static void main(String[] args) {
        String a = "abcdef";
        System.out.println(invert(a));
        System.out.println(invert(null));

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }
}
