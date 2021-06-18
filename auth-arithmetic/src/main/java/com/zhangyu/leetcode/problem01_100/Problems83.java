package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/4/27 5:27 下午
 */
@Slf4j
public class Problems83 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        deleteDuplicates(listNode);
        System.out.println();

    }

    /**
     * @description:
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:37.9 MB,击败了58.71% 的Java用户
     * @author: zhangyu122
     * @date: 2021/4/28 1:51 下午
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode current = head;
        while (current.next != null){
            int currentValue = current.val;
            ListNode nextNode = current.next;
            int nextVal = nextNode.val;
            if (currentValue == nextVal){
                current.next = nextNode.next;
                continue;
            }
            current.next = nextNode;
            current = nextNode;
        }
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
