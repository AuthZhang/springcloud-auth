package com.zhangyu.leetcode.problem01_100;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2020/12/1 7:27 下午
 */
public class Problems13 {
    public static int romanToInt1(String s){

        return 0;
    }
    public static int getValue(char p){
        switch (p) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * @description:
     * 执行耗时:4 ms,击败了99.98% 的Java用户
     * 内存消耗:38.8 MB,击败了67.70% 的Java用户
     *
     * IV   4       IX  9
     * XL   40      XC  90
     * CD   400     CM  900
     *
     * I    1
     * X    10
     * C    100
     * V    5
     * L    50
     * D    500
     * M    1000
     *
     * @author: zhangyu122
     * @date: 2020/11/30 6:35 下午
     */
    public static int romanToInt(String s){
        char[] params = s.toCharArray();
        int i = 0;
        for (int j = 0 ; j < params.length ; j ++){
            switch (params[j]){
                case 'I':
                    if (params.length-j-1>0 && params[j+1] == 'V'){
                        i += 4;
                        ++j;
                        break;
                    }else if (params.length-j-1>0 && params[j+1] == 'X'){
                        i+=9;
                        ++j;
                        break;
                    }
                    i+=1;
                    if (params.length-j-1>0 && params[j+1] == 'I'){
                        i+=1;
                        ++j;
                    }
                    if (params.length-j-2>0 && params[j+2] == 'I'){
                        i+=1;
                        ++j;
                    }
                    if (params.length-j-3 > 0 && params[j+3] == 'I'){
                        i+=1;
                        ++j;
                    }
                    break;
                case 'X':
                    if (params.length-j-1>0 && params[j+1] == 'L'){
                        i += 40;
                        ++j;
                        break;
                    }else if (params.length-j-1>0 && params[j+1] == 'C'){
                        i+=90;
                        ++j;
                        break;
                    }
                    i+=10;
                    break;
                case 'C':
                    if (params.length-j-1>0 && params[j+1] == 'D'){
                        i += 400;
                        ++j;
                        break;
                    }else if (params.length-j-1>0 && params[j+1] == 'M'){
                        i+=900;
                        ++j;
                        break;
                    }
                    i+=100;
                    break;
                case 'V':
                    i+=5;
                    break;
                case 'L':
                    i+=50;
                    break;
                case 'D':
                    i+=500;
                    break;
                case 'M':
                    i+=1000;
                    break;
                default:
                    break;
            }
        }
        return i;
    }
}
