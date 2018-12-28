package com.sununiq.snippet.jianzhioffer;

import com.sununiq.snippet.jianzhioffer.domain.TreeNode;

/**
 * 二叉搜索树 => 双向链表
 * 中序遍历：从小到大排列，添加指针指向
 **/
public class Question27 {
  TreeNode head;
  TreeNode tail;

  public TreeNode convert(TreeNode root) {
    if (root == null) {
      return null;
    }

    convertNode(root);
    return head;
  }

  private void convertNode(TreeNode cur) {
    if (cur == null) {
      return;
    }

    convertNode(cur.left);

    // 中序遍历第一个访问到的元素，即最小的元素，即双向链表的头，此时尾结点也指向他
    if (head == null) {
      head = cur;
      tail = cur;
    } else {
      //当前根结点插入到左子树生成的链表的尾端，tail向后移动
      tail.right = cur;
      cur.left = tail;
      tail = cur;
    }

    convertNode(cur.right);
  }

  public static void main(String[] args) {
    TreeNode head = new TreeNode(8);
    TreeNode left = head.left(6);
    TreeNode right = head.right(10);

    left.left(5);
    left.right(7);

    right.left(9);
    right.right(11);

    TreeNode root = new Question27().convert(head);

    System.out.println(root.value);
  }
}
