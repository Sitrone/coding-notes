package com.sununiq.snippet.jianzhioffer;

import com.sununiq.snippet.jianzhioffer.domain.TreeNode;

/**
 * 1. 二叉树的深度 2. 判断是否是平衡二叉树
 * https://leetcode.com/problems/balanced-binary-tree/
 **/
public class Question39 {

  static int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(depth(root.left), depth(root.right)) + 1;
  }

  static boolean isBinaryTree(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
      return false;
    }

    return isBinaryTree(root.left) && isBinaryTree(root.right);
  }

  /**
   * 边递归边求解深度，避免重复求取
   * TODO 是否有更好的解法
   */
  static boolean isBinaryTree2(TreeNode root) {
    return isBalanced(root) != -1;
  }

  private static int isBalanced(TreeNode t) {
    if (t == null) {
      return 0;
    }

    int leftHeight = isBalanced(t.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = isBalanced(t.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
