package com.sununiq.snippet.jianzhioffer.domain;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode next(int value) {
    ListNode listNode = new ListNode(value);
    this.next = listNode;
    return listNode;
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + val + ", next=" + next + '}';
  }
}
