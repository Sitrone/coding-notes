package com.sununiq.snippet.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 圆圈中最后剩下的数字 约瑟夫环
 * 1. 暴力解法，一次次循环，直到剩下的那个数
 * 2. 使用队列来轮询
 * 3. 递推公司 f(N, M)=(f(N−1, M) + M) % N
 **/
public class Question45 {

  public static void main(String[] args) {
//    System.out.println(lastRemaining(5, 3));
//    System.out.println(lastRemaining1(5, 3));
    System.out.println(lastRemaining0(5, 3));

//    for (int i = 1; i < 30; i++) {
//      System.out.println(lastRemaining(i, 3));
//    }
  }

  // 通用解法
  static int lastRemaining(int n, int m) {
    if (n < 1 || m < 1) {
      throw new IllegalArgumentException();
    }

    LinkedList<Integer> persons = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      persons.offer(i);
    }

    int current = 0;
    while (persons.size() != 1) {
      current += (m - 1);
      if (current >= persons.size()) {
        current %= persons.size();
      }

      persons.remove(current);
    }

    return persons.peek();
  }

  /**
   * 使用队列解决
   */
  static int lastRemaining0(int n, int m) {
    if (n < 1 || m < 1) {
      throw new IllegalArgumentException();
    }

    Queue<Integer> persons = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      persons.offer(i);
    }

    long counts = 0;//计数器
    while (persons.size() > 1) {
      //1.出队列
      Integer person = persons.poll();
      //2.计数器++
      counts++;

      //3.判断
      if (counts % m == 0) {
        //是,打印
        System.out.print(person + " ");
      } else {
        //不是,继续入队列
        persons.add(person);
      }
    }

    System.out.println("\n" + counts);
    return persons.peek();
  }

  /**
   *  递归解法，参考答案 TODO
   */
  static int lastRemaining1(int n, int k) {
    if (n < 1 || k < 1) {
      throw new IllegalArgumentException();
    }

    if (n == 1) {
      return 1;
    } else
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */ {
      return (lastRemaining1(n - 1, k) + k - 1) % n + 1;
    }
  }
}
