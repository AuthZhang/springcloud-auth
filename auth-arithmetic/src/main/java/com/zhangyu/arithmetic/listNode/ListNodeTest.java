package com.zhangyu.arithmetic.listNode;

/**
 * @Author zhangyu
 * @Description
 * @Date 20:40 2021/9/17
 **/
public class ListNodeTest {

    /**
     * @Author zhangyu
     * @Description
     * 将单链表的链接顺序反转过来
     * 比如：
     *      输入：1-2-3-4-5
     *      输出：5-4-3-2-1
     * @Date 20:40 2021/9/17
     **/
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
        ListNode(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
//        ListNode listNode = invertWhile(listNode1);
        ListNode listNodeI = invertWhileVersion1(listNode1,2,4);
        System.out.println();
    }

    /**
     * @Author zhangyu
     * @Description 指定区间反转  初始版本
     * 1 <= m <= n
     * m = 2,n = 4时，结果应该是：14325
     * @Date 15:43 2021/10/29
     */
    public static ListNode invertWhileVersion1(ListNode head,int m,int n){
        if (m == n || head ==null || head.next ==null){
            return head;
        }
        ListNode result = head;
        ListNode startInvert = head; // m 位置的node
        ListNode endInvert = head; // n 位置的node
        ListNode preStart = startInvert; // m-1位置的node
        int c = 1;
        while (c<n){
            if (c < m){
                preStart = startInvert;
                startInvert = startInvert.next;
                endInvert = startInvert;
                c++;
                continue;
            }
            if (endInvert != null)
                endInvert = endInvert.next;
            c++;
        }
        ListNode pre = startInvert; // m 位置的node
        ListNode current = startInvert.next; // m+1位置的node
        ListNode next;
        endInvert = endInvert.next;
        pre.next = endInvert; // 将m位置的next赋值为n+1位置的node
        while (current != endInvert){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        if (m == 1){
            return pre;
        }
        preStart.next = pre; // 将m-1位置的next赋值为反转区间的头结点
        return result;
    }

    /**
     * @Author zhangyu
     * @Description 单链表反转
     *              迭代的方式
     * @Date 20:47 2021/9/17
     **/
    public static ListNode invertWhile(ListNode head){
        ListNode pre = null;
        ListNode next;
        ListNode current = head;
        while (current!=null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * @Author zhangyu
     * @Description 单链表反转
     *              递归
     * @Date 20:47 2021/9/17
     **/
    public static ListNode invertRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode listNode = invertRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


}
