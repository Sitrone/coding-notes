package com.sununiq.snippet.concurrent.tool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用交替锁，七周七并发
 * 只能使用ReentrantLock实现，无法使用内置锁实现
 **/
public class ConcurrentSortedList {
  private class Node{
    int value;
    Node pre;
    Node next;
    ReentrantLock lock = new ReentrantLock();

    public Node() { }

    public Node(final int value, final Node pre, final Node next) {
      this.value = value;
      this.pre = pre;
      this.next = next;
    }
  }

  private final Node head;
  private final Node tail;

  public ConcurrentSortedList() {
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.pre = head;
  }

  public void insert(int value) {
    Node current = head;
    current.lock.lock();
    Node next = current.next;

    try {
      while (true) {
        next.lock.lock();
        try {
          if (next == tail || next.value < value) {
            Node node = new Node(value, current, next);
            next.pre = node;
            current.next = node;
            return;
          }
        }finally {
          current.lock.unlock();
        }

        current = next;
        next = next.next;
      }
    }finally {
      next.lock.unlock();
    }
  }

  public int size() {
    Node current = tail;
    int count = 0;

    while (current.pre != head) {
      ReentrantLock lock = current.lock;
      lock.lock();
      try {
        ++count;
        current = current.next;
      }finally {
        lock.unlock();
      }
    }
    return count;
  }
}
