package com.sununiq.snippet.jianzhioffer;

/**
 *
 **/
public class Question46 {
  public static void main(String[] args) {
    int sum = sumOfN(100);
    System.out.println(sum);
  }

  static int sumOfN(int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }

    return n * (n + 1) / 2;
  }
}
