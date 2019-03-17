package com.sununiq.snippet.algs.domain;

public class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }

  public TreeNode(final int value, final TreeNode left, final TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public TreeNode left(int value) {
    TreeNode treeNode = new TreeNode(value);
    this.left = treeNode;
    return treeNode;
  }

  public TreeNode right(int value) {
    TreeNode treeNode = new TreeNode(value);
    this.right = treeNode;
    return treeNode;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + value + ", left=" + left + ", right=" + right + '}';
  }
}
