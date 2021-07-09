package com.zhangyu.leetcode.problem101_200;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/6/25 3:34 下午
 */
@Slf4j
public class Problems118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        List<List<Integer>> generate1 = generate1(5);
        log.info("");
    }


    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i<numRows;i++){
            List<Integer> firstItem = new ArrayList<>();
            for (int j=0;j<i+1;j++){
                if (j == 0 || j==i){
                    firstItem.add(1);
                }else {
                    List<Integer> list = result.get(i - 1);
                    firstItem.add(list.get(j-1) + list.get(j));
                }
            }
            result.add(firstItem);
        }
        return result;
    }


    /**
     * @description:
     *
     *                                解答成功:
     * 				执行耗时:1 ms,击败了55.18% 的Java用户
     * 				内存消耗:36.2 MB,击败了65.92% 的Java用户
     * @author: zhangyu122
     * @date: 2021/7/6 4:55 下午
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstItem = new ArrayList<>();
        firstItem.add(1);
        result.add(firstItem);
        if (numRows == 1){
            return result;
        }
        return a(firstItem,result,numRows);
    }

    public static List<List<Integer>> a(List<Integer> preItem,List<List<Integer>> result,int numRows){
        int preSize = preItem.size();
        if (preSize == numRows){
            return result;
        }
        List<Integer> list = new ArrayList<>(preSize+1);
        list.add(1);
        for (int i = 0;i<preSize-1;i++){
            list.add(preItem.get(i)+preItem.get(i+1));
        }
        list.add(1);
        result.add(list);
        return a(list,result,numRows);
    }

}
