package com.sununiq.snippet.algs.domain;

public class ListNode {
  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
  }

  public ListNode next(int value) {
    ListNode listNode = new ListNode(value);
    this.next = listNode;
    return listNode;
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + value + ", next=" + next + '}';
  }
}
