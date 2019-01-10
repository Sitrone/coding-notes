package com.sununiq.snippet.jianzhioffer;

import com.sununiq.snippet.jianzhioffer.domain.ListNode;
import com.sununiq.snippet.jianzhioffer.util.ListUtils;

/**
 *
 **/
public class Question57 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 1, 2, 3};
    ListNode head = ListUtils.covert2List(arr);

//    deleteDuplicate(first);
    System.out.println(deleteDuplicate1(head));
  }

  /**
   * leetcode 83 删除重复节点，只保留一个
   *
   * @param head
   */
  public static ListNode deleteDuplicate(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  /**
   * leetcode 82
   *
   * @param head
   */
  public static ListNode deleteDuplicate1(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode pre = new ListNode(Integer.MAX_VALUE);
    ListNode cur = head;
    pre.next = cur;
    head = pre;

    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }
      if (pre.next == cur) {
        pre = pre.next; // cur.val is distinct, move pre to next
      } else {
        pre.next = cur.next; // skip duplicates, but pre shouldn't move now
      }

      cur = cur.next;
    }

    return head.next;
  }
}
