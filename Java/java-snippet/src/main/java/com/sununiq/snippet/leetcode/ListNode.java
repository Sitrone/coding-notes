package com.sununiq.snippet.leetcode;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  ListNode next(int temp) {
    ListNode nextNode = new ListNode(temp);
    next = nextNode;
    return nextNode;
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + val + ", next=" + next + '}';
  }
}
