package com.sununiq.snippet.jianzhioffer;

import com.sununiq.snippet.jianzhioffer.domain.ListNode;

/**
 * 在O(1)时间删除链表节点, 前提，链表中确实存在节点
 */
public class Question13 {
  public static void main(String[] args) {
    ListNode first = new ListNode(1);
    ListNode s = new ListNode(2);
    ListNode t = new ListNode(3);
    ListNode f = new ListNode(4);
    ListNode fi = new ListNode(5);

    first.next = s;
    s.next = t;
    t.next = f;
    f.next = fi;

    deleteNode(first, f);

    System.out.println(first);
  }

  static void deleteNode(ListNode head, ListNode toBeDeleted) {
    if (head == null || toBeDeleted == null) {
      return;
    }

    ListNode next = toBeDeleted.next;

    // 链表有多个节点，要删除的不是尾节点:O(1)时间
    // 使用下一个节点来覆盖待删除的节点
    if (next != null) {
      toBeDeleted.val = next.val;
      toBeDeleted.next = next.next;
      next = null;

      // 链表只有一个结点，删除头结点（也是尾结点）:O(1)时间
    } else if (head == toBeDeleted) {
      head = null;
      toBeDeleted = null;

      // 链表有多个节点，要删除的是尾节点:O(n)时间
    } else {
      ListNode cur = head;
      while (cur.next != toBeDeleted) {
        cur = cur.next;
      }

      cur.next = null;
      toBeDeleted = null;
    }
  }
}
