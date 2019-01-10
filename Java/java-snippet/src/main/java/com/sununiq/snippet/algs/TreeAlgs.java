package com.sununiq.snippet.algs;

import com.sununiq.snippet.algs.domain.TreeNode;

/**
 *
 **/
public class TreeAlgs {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(new TreeAlgs().maxPathSum(root));
  }

  /**
   * https://leetcode.com/problems/binary-tree-maximum-path-sum/
   * http://www.cnblogs.com/grandyang/p/4280120.html
   * 二叉树最大路径和
   */
  private int ret = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    subMaxPathSum(root);
    return ret;
  }

  // 最大路径一定是以某节点为根，加上左右子树中的最大路径和
  private int subMaxPathSum(final TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = subMaxPathSum(root.left);
    int right = subMaxPathSum(root.right);

    //以当前节点为根节点的路径最大和
    ret = Math.max(ret, Math.max(left, 0) + Math.max(right, 0) + root.value);

    //返回 经过当前节点的路径最大和
    return Math.max(Math.max(left, right), 0) + root.value;
  }
}
