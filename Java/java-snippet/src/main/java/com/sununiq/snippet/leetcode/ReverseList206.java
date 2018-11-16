package com.sununiq.snippet.leetcode;

public class ReverseList206 {
  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next(2).next(3).next(4).next(5);
    final ListNode listNode = new ReverseList206().reverseList2(root);
    System.out.println(listNode);
  }

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    return pre;
  }

  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode next = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return next;
  }
}
