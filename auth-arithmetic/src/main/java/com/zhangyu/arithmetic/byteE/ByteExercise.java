package com.zhangyu.arithmetic.byteE;

public class ByteExercise {

    /**
     * @Author zhangyu
     * @Description 输入整数，输出二进制的反码对应的十进制数字
     * @Date 17:33 2021/10/20
     */
    public static int get(Integer arg){
        String s = Integer.toBinaryString(arg);
        byte[] bytes = s.getBytes();
        for(int i = 0;i<bytes.length;i++){
            if (bytes[i] == 49){
                bytes[i] =48;
            }else {
                bytes[i] =49;
            }
        }
        int result = 0;
        for(int i =0;i<bytes.length;i++){
            if(bytes[i] == 48){
                continue;
            }
            int d = bytes.length-1 -i;
            // 2的d次方
            int temp = (int)Math.pow(2,d);
            result += temp;
        }
        return result;
    }
}
