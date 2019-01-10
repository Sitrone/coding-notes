package com.sununiq.snippet.algs;

public class CountChange {
  public static void main(String[] args) {
    System.out.println(countChange(100));
  }

  //零钱的种类
  private static final int[] nums = new int[]{1, 5, 10, 25, 50};

  public static int countChange(int amount) {
    return helper(amount, 5);
  }

  /**
   * sum = 没有使用第一种零钱的方式 + 用了第一种换钱方式
   *
   * @param amount
   * @param kindsOfCoins
   * @return 找零的方法数目
   */
  private static int helper(int amount, int kindsOfCoins) {
    if (amount == 0) {
      return 1;
    } else if (amount < 0 || kindsOfCoins == 0) {
      return 0;
    } else {
      return helper(amount, kindsOfCoins - 1) + helper((amount - nums[kindsOfCoins - 1]), kindsOfCoins);
    }
  }

  public static int fib(int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }
    int[] fib = new int[n + 1];
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }

    return fib[n];
  }
}
