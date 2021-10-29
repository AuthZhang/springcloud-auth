import com.auth.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author zhangyu
 * @Description 二叉树遍历算法
 * @Date 17:54 2021/9/22
 */
@Slf4j
@SpringBootTest(classes = Application.class)
class ArithmeticBinaryTreeTraverseTests {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(int val){
            this.val = val;
        }

    }

    /**
     * @Author zhangyu
     * @Description 前序遍历
     * 递归
     * @Date 16:33 2021/9/22
     */
    @Test
    void test2() {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
//        qianxubinali(node1);
//        qianxubinalidiedai(node1);
//        zhognxubinali(node1);
//        System.out.println();
//        zhognxubinalidiedai(node1);
//        houxubianli(node1);
//        System.out.println();
//        houxubinalidiedai(node1);
        cengxubianli1(node1);
        System.out.println();
        cengxubinalidiedai(node1);
    }

    /**
     * @Author zhangyu
     * @Description 前序遍历
     * 递归
     * @Date 16:45 2021/9/22
     */
    private void qianxubinali(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val); // 第一次成为栈顶元素即打印
        qianxubinali(root.left);
        qianxubinali(root.right);
    }

    /**
     * @Author zhangyu
     * @Description 中序遍历
     * @Date 16:45 2021/9/22
     */
    private void zhognxubinali(TreeNode root){
        if (root == null){
            return;
        }
        zhognxubinali(root.left);
        System.out.print(root.val); // 第二次成为栈顶元素即打印
        zhognxubinali(root.right);
    }

    /**
     * @Author zhangyu
     * @Description 后序遍历
     * @Date 16:45 2021/9/22
     */
    private void houxubianli(TreeNode root){
        if (root == null){
            return;
        }
        houxubianli(root.left);
        houxubianli(root.right);
        System.out.print(root.val); // 第三次成为栈顶元素即打印
    }

    /**
     * @Author zhangyu
     * @Description 层序遍历
     * 先从上到下、后从左到右
     * @Date 17:34 2021/9/22
     */
    private void cengxubianli1(TreeNode root){
        List list = new ArrayList();
        cengxubinali11(root,1,list);
        list.stream().forEach(item->{
            if (item != null){
                System.out.print(item);
            }
        });
    }
    /**
     * @Author zhangyu
     * @Description
     * @Date 17:35 2021/9/22
     * @param node 父节点
     * @param i 父节点的下标
     * @param list 存储节点值的集合
     */
    private void cengxubinali11(TreeNode node,int i,List list){
        if (node == null){
            return;
        }
        int size = list.size();
        if (size <= i){
            for (int j = 0;j<=i-size;j++){
                list.add(j+size,null);
            }
        }
        list.set(i,node.val);
        cengxubinali11(node.left,2*i,list);
        cengxubinali11(node.right,2*i+1,list);
    }


    /**
     * @Author zhangyu
     * @Description 前序遍历  根左右
     * 迭代
     * @Date 16:45 2021/9/22
     */
    private void qianxubinalidiedai(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop == null){
                continue;
            }
            System.out.println(pop.val);
            stack.push(pop.right);
            stack.push(pop.left);
        }
    }
    /**
     * @Author zhangyu
     * @Description 中序遍历  左根右
     * 迭代
     * @Date 16:45 2021/9/22
     */
    private void zhognxubinalidiedai(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val);
                root = pop.right;
            }
        }
    }

    /**
     * @Author zhangyu
     * @Description 后序遍历  左右根
     * 迭代
     * 4675231
     * @Date 16:45 2021/9/22
     */
    private void houxubinalidiedai(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre){
                System.out.print(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
    }



    /**
     * @Author zhangyu
     * @Description 层序遍历
     * 遍历
     * @Date 16:36 2021/9/23
     */
    private void cengxubinalidiedai(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if ( root == null){
                continue;
            }
            System.out.print(root.val);
            TreeNode left = root.left;
            if (left != null)
                queue.add(left);
            TreeNode right = root.right;
            if (right != null)
                queue.add(right);
        }
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** morris 遍历 ******************************************************************
     * ********************************************************************************************************************************************
     **/





}
