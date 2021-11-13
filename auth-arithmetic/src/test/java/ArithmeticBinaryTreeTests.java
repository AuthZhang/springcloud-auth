
import com.zhangyu.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @Author zhangyu
 * @Description 二叉树算法练习
 * @Date 19:28 2021/9/21
 */
@Slf4j
@SpringBootTest(classes = Application.class)
class ArithmeticBinaryTreeTests {

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
     * @Description 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
     *
     * @Date 19:31 2021/9/21
     */
    @Test
    void test1() {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,node7,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,node6,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(minDepth1(node1));
    }

    /**
     * @Author zhangyu
     * @Description 深度优先
     * 叶子节点深度记为1
     * 左子树和右子树分别递归
     * @Date 19:41 2021/9/21
     */
    private int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if ( left == null && right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (left != null){
            min = Math.min(min,minDepth(left));
        }
        if (right != null){
            min = Math.min(min,minDepth(right));
        }
        return min+1;
    }

    /**
     * @Author zhangyu
     * @Description 广度优先
     * 根节点记为1
     * 用一个队列依次存储节点
     * 左子树和右子树分别递归
     * @Date 19:41 2021/9/21
     */
    private int minDepth1(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int result = 1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if (left != null ^ right != null){
                return result;
            }
            result ++;
            queue.add(left);
            queue.add(right);
        }
        return result;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

















}
