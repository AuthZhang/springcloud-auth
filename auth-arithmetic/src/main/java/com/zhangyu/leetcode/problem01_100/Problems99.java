package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;
import sun.tools.asm.TryData;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/8/10 2:40 下午
 */
@Slf4j
public class Problems99 {

    public static void main(String[] args) {

    }

    public static void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode error1 = null;
        TreeNode error2 = null;
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode left = root.left;
            if (left != null){
                if (left.val <= root.val){
                    stack.push(left);
                    root = left;
                    continue;
                }else {
                    error1 = left;
                }
            }
            TreeNode right = root.right;
            if (right != null){
            }
        }

    }

    public static void leftSearch(Stack stack,TreeNode root){

    }
    public static void rightSearch(Stack stack,TreeNode root){

    }


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
