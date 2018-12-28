package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 **/
public class Question41 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 11, 15};

    System.out.println(Arrays.toString(findNumberWithSum(arr, 15)));
    System.out.println(Arrays.toString(findNumberWithSum1(arr, 15)));

    findContinuousSequence(arr, 15);
  }

  /**
   * 从已经排序好的数组中找到和为s的序对
   *
   * @param arr
   * @param sum
   * @return
   */
  static int[] findNumberWithSum(int[] arr, int sum) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException();
    }

    Set<Integer> set = new HashSet<>();
    for (final int n : arr) {
      set.add(n);
    }

    for (final int n : arr) {
      if (set.contains(sum - n)) {
        return new int[]{n, sum - n};
      }
    }
    return null;
  }

  // 双指针法
  static int[] findNumberWithSum1(int[] arr, int sum) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException();
    }

    int i = 0, j = arr.length - 1;
    while (i <= j) {
      if (arr[i] + arr[j] == sum) {
        return new int[]{arr[i], arr[j]};
      } else if (arr[i] + arr[j] > sum) {
        j--;
      } else {
        i++;
      }
    }

    return null;
  }

  /**
   * 找到排序数组中连续的序列（至少包含两个数字）和为sum
   *
   * 参考上面的解法，同样使用双指针
   */
  static void findContinuousSequence(int[] arr, int sum) {
    if (arr == null || arr.length <= 1) {
      throw new IllegalArgumentException();
    }

    int i = 0, j = 1;
    while (j < arr.length && i < j) {
      int subArraySum = subArraySum(arr, i, j);
      if (subArraySum == sum) {
        printSubArray(arr, i, j);
        j++;
      } else if (subArraySum > sum) {
        i++;
      } else {
        j++;
      }
    }
  }

  private static int subArraySum(int[] arr, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += arr[i];
    }
    return sum;
  }

  private static void printSubArray(int[] arr, int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
