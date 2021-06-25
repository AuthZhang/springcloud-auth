package com.zhangyu.thread.printABC.way1;
/**
 * 
 * Created by zhangyu on 2018/9/6.
 */

public class PrintLetter {

    /**
     *   内存中只维护一个PrintLetter对象，初始化该对象的同时初始化letter为A
     * @author zhangyu
     * @date 2018/9/6
     */
    private char letter ='A';

    /**
     *   打印当前字符
     * @author zhangyu
     * @date 2018/9/6
     */
    public void printLetter(){
        System.out.print(this.letter);
        if (this.letter == 'C'){
            System.out.println();
        }
    }

    /**
     *   获取下一个字符
     * @author zhangyu
     * @date 2018/9/6
     */
    public char nextChar() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'A';
                break;
            default:
                break;
        }
        return letter;
    }

    public char getLetter() {
        return letter;
    }
}
