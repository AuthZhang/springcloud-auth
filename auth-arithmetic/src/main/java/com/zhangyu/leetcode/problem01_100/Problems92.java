package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/6/25 3:34 下午
 */
@Slf4j
public class Problems92 {

    public static void main(String[] args) {

    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.3 MB,击败了5.38% 的Java用户
     * 	思路：
     * 	将链表转为数组，采用双指针将元素交换完毕，在把数组转为链表
     * @author: zhangyu122
     * @date: 2021/7/28 7:18 下午
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return head;
        }
        List<Integer> list= new ArrayList();
        while (head != null){
            list.add(head.val);
            ListNode next = head.next;
            if (next == null){
                break;
            }
            head = next;
        }

        int p = left-1 == 0 ? 0 : left-1;
        int q = right-1 == 0? 0 : right-1;
        while (p < q){
            Integer integerQ = list.get(q);
            int temp = list.get(p);
            list.set(p,integerQ);
            list.set(q,temp);
            p++;
            q--;
        }
        ListNode root = new ListNode(list.get(0));
        ListNode temp = root;
        for (int i = 1;i<list.size();i++){
            ListNode current = new ListNode(list.get(i));
            temp.next = current;
            temp = current;
        }
        return root;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
