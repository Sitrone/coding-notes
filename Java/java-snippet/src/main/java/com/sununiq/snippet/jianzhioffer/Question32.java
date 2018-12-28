package com.sununiq.snippet.jianzhioffer;

/**
 * 从1到n整数中1出现的次数
 * 1. 暴力解法
 * 2. 采用编程之美中的方法 TODO
 **/
public class Question32 {

  public static void main(String[] args) {

  }

  static int numberOf1Between1ToN(int n) {
    int count = 0;

    for (int i = 0; i <= n; i++) {
      int temp = i;
      //如果temp的任意位为1则count++
      while (temp != 0) {
        if (temp % 10 == 1) {
          count++;
        }
        temp /= 10;
      }
    }
    return count;
  }
}
