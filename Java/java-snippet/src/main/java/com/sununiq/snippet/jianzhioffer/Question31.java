package com.sununiq.snippet.jianzhioffer;

/**
 * 连续子数组的最大和
 **/
public class Question31 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
    System.out.println(findMasSumOfSubArray(arr));
  }

  static int findMasSumOfSubArray(int[] numbers) {
    int subSum = 0;
    int sum = Integer.MIN_VALUE;

    for (final int number : numbers) {
      if (subSum <= 0) {
        subSum = number;
      } else {
        subSum += number;
      }

      if (subSum > sum) {
        sum = subSum;
      }
    }

    return sum;
  }
}
