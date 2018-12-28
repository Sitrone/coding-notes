package com.sununiq.snippet.jianzhioffer;

import com.sununiq.snippet.jianzhioffer.domain.ListNode;

import java.util.Stack;

/**
 * 找到两个链表的第一个公共节点，使用stack
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 **/
public class Question37 {

  public static void main(String[] args) {

  }

  static ListNode findFirstCommonNode(ListNode node1, ListNode node2) {
    Stack<ListNode> stack1 = new Stack<>();
    Stack<ListNode> stack2 = new Stack<>();

    ListNode cur1 = node1;
    while (cur1 != null) {
      stack1.push(cur1);
      cur1 = cur1.next;
    }

    ListNode cur2 = node2;
    while (cur2 != null) {
      stack2.push(cur2);
      cur2 = cur2.next;
    }

    ListNode result = null;
    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      ListNode pop1 = stack1.pop();
      ListNode pop2 = stack2.pop();
      if (pop1 == pop2) {
        result = pop1;
      } else {
        break;
      }
    }

    return result;
  }
}
