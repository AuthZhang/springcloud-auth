
import com.zhangyu.Application;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangyu.arithmetic.listNode.ListNodeTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @Author zhangyu
 * @Description 链表算法练习
 * @Date 15:31 2021/9/18
 **/
@Slf4j
@SpringBootTest(classes = Application.class)
class ArithmeticListNodeTests {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        ListNode(int val){
            this.val = val;
        }

    }

    /**
     * @Author zhangyu
     * @Description 环形链表判断
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪next指针再次到达该节点，则链表中存在环
     * 如果链表中有环，则返回true，否则，返回false
     * @Date 20:51 2021/9/20
     */
    @Test
    void test1() {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        node5.next = node3;
        System.out.println(rang2(node1));
    }

    /**
     * @Author zhangyu
     * @Description
     * @Date 22:08 2021/9/20
     */
    private boolean rang(ListNode listNode){
        if (listNode.next == null){
            return false;
        }
        ListNode current = listNode;
        ListNode next = listNode.next;
        if (next == null){
            return false;
        }
        Map<ListNode, Boolean> flag = new HashMap<>();
        while (current.next != null){
            if (current == next.next){
                return true;
            }
            if (next.next == null){
                current = next;
                next = current.next;
                flag.clear();
                continue;
            }else if (flag.containsKey(next.next)){
                return true;
            }else {
                flag.put(next,true);
                next = next.next;
            }
        }
        return false;
    }

    /**
     * @Author zhangyu
     * @Description
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @Date 22:09 2021/9/20
     */
    private boolean rang1(ListNode listNode){
        Set<ListNode> set = new HashSet<>();
        while (listNode != null){
            if (!set.add(listNode)){
                return true;
            }
            listNode = listNode.next;
        }
        return false;
    }

    /**
     * @Author zhangyu
     * @Description 双指针
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @Date 22:09 2021/9/20
     */
    private boolean rang2(ListNode listNode){
        if (listNode == null || listNode.next == null){
            return false;
        }
        ListNode l = listNode;
        ListNode r = listNode.next;
        while (l != r){
           if (r == null && r.next == null){
               return false;
           }
           l = l.next;
           r = r.next.next;
        }
        return true;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

}
