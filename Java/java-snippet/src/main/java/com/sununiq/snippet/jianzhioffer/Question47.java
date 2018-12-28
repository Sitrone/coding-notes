package com.sununiq.snippet.jianzhioffer;

/**
 * 不用加减乘除做加法
 * 使用位运算，参考门电路模拟加法
 * 异或求和，与求进位
 **/
public class Question47 {
  public static void main(String[] args) {
    System.out.println(add(5, 7));
  }

  static int add(int x, int y) {
    int sum, carry;
    do {
      sum = x ^ y;
      carry = (x & y) << 1;
      x = sum;
      y = carry;
    } while (y != 0);

    return sum;
  }
}
