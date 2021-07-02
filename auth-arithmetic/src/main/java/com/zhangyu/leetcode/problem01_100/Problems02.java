package com.zhangyu.leetcode.problem01_100;

import java.util.List;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/7/2 1:54 下午
 */
public class Problems02 {

    public static void main(String[] args) {
        ListNode l1 =  new ListNode(2);
        ListNode l2 =  new ListNode(4);
        l1.next = l2;
        ListNode l3 =  new ListNode(3);
        l2.next=l3;


        ListNode v1 =  new ListNode(5);
        ListNode v2 =  new ListNode(6);
        v1.next = v2;
        ListNode v3 =  new ListNode(4);
        v2.next=v3;

        ListNode listNode = addTwoNumbers(l1, v1);
        System.out.println();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int i = l1.val + l2.val;
        result.val = i;
        if (l1.next!=null && l2.next!=null){
            if (i >=10){
                l1.next.val = ++l1.next.val;
                result.val = i -10;
            }
            result.next = addTwoNumbers(l1.next, l2.next);
            return result;
        }
        if (l1.next == null && l2.next == null){
            if (i>=10){
                result.val = i-10;
                ListNode last = new ListNode();
                last.val=1;
                result.next = last;
            }
            return result;
        }
        if (l1.next == null){
            ListNode v =  new ListNode(0);
            if (i>=10){
                result.val = i-10;
                v.val=1;
            }
            result.next = addTwoNumbers(v,l2.next);
        }
        if (l2.next == null){
            ListNode v =  new ListNode(0);
            if (i>=10){
                result.val = i-10;
                v.val=1;
            }
            result.next = addTwoNumbers(l1.next,v);
        }
        return result;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
