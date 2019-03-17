package com.sununiq.snippet.algs;

import com.sununiq.snippet.algs.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 **/
public class TreeAlgs {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(new TreeAlgs().maxPathSum(root));

    root = createBT();
    preTraverse(root);
    System.out.println();
    preTraverseIter(root);
    System.out.println();

    inTraverse(root);
    System.out.println();
    inTraverseIter(root);
    System.out.println();

    postTraverse(root);
    System.out.println();
    postTraverseIter(root);
  }

  /**
   * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
   * @param root
   */
  public static void preTraverse(TreeNode root) {
    if (root != null) {
      System.out.print(root.value + " ");
      preTraverse(root.left);
      preTraverse(root.right);
    }
  }

  public static void preTraverseIter(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (cur == null) {
        continue;
      }

      System.out.print(cur.value + " ");
      stack.push(cur.right);
      stack.push(cur.left);
    }
  }

  public static void inTraverse(TreeNode root) {
    if (root != null) {
      inTraverse(root.left);
      System.out.print(root.value + " ");
      inTraverse(root.right);
    }
  }

  public static void inTraverseIter(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }

      if (!stack.isEmpty()) {
        TreeNode temp = stack.pop();
        System.out.print(temp.value + " ");
        cur = temp.right;
      }
    }
  }

  public static void postTraverse(TreeNode root) {
    if (root != null) {
      postTraverse(root.left);
      postTraverse(root.right);
      System.out.print(root.value + " ");
    }
  }

  /**
   * leetcode中有人给出了一个”巧“的方法，即先采用类似先序遍历，
   * 先遍历根结点再右孩子最后左孩子（先序是先根结点再左孩子最后右孩子），最后把遍历的序列逆转即得到了后序遍历
   * @param root
   */
  public static void postTraverseIter(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    List<Integer> ret = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        ret.add(node.value);
        stack.push(node.left);
        stack.push(node.right);
      }
    }
    Collections.reverse(ret);
    System.out.println(ret);
  }

  //简单创建一个简单的二叉树
  public static TreeNode createBT() {
    TreeNode i = new TreeNode(9);
    TreeNode h = new TreeNode(8);
    TreeNode g = new TreeNode(7);
    TreeNode e = new TreeNode(6);
    TreeNode f = new TreeNode(5, h, i);
    TreeNode d = new TreeNode(4, null, g);
    TreeNode c = new TreeNode(3, f, null);
    TreeNode b = new TreeNode(2, d, e);
    return new TreeNode(1, b, c);
  }

  /**
   * https://leetcode.com/problems/binary-tree-maximum-path-sum/ http://www.cnblogs.com/grandyang/p/4280120.html
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
