package com.sununiq.snippet.jianzhioffer.util;

import com.sununiq.snippet.jianzhioffer.domain.ListNode;

/**
 *
 **/
public class ListUtils {

  public static ListNode covert2List(int[] arr) {
    if (arr == null) {
      return null;
    }
    ListNode head = new ListNode(arr[0]);
    ListNode cur = head;
    for (int i = 1; i < arr.length; i++) {
      cur.next = new ListNode(arr[i]);
      cur = cur.next;
    }
    return head;
  }
}
