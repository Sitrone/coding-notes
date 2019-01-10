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

    for (int number : numbers) {
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

  /**
   * 动态规划：MaxSum[i] = Max{ MaxSum[i-1] + A[i], A[i]}
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   */
  public static int maxSubSequence3(int[] array) {
    int[] maxSumArr = new int[array.length];
    maxSumArr[0] = array[0];

    for (int i = 1; i < array.length; i++) {
      maxSumArr[i] = Math.max(maxSumArr[i - 1] + array[i], array[i]);
    }

    //找到MaxSum中的最大值
    int maxSum = Integer.MIN_VALUE;
    for (int n : maxSumArr) {
      if (n > maxSum) {
        maxSum = n;
      }
    }

    return maxSum;
  }
}
