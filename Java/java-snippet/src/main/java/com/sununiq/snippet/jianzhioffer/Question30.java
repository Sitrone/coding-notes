package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数 1. 小顶堆 2. 基于partition来求解
 **/
public class Question30 {
  public static void main(String[] args) {
    int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
    System.out.println(Arrays.toString(getLeastNumbers(nums, 4)));

    System.out.println(Arrays.toString(getLeastNumbers2(nums, 4)));
  }

  static int[] getLeastNumbers(int[] numbers, int k) {
    if (numbers == null || k <= 0 || k >= numbers.length) {
      throw new IllegalArgumentException();
    }

    Queue<Integer> queue = new PriorityQueue<>();
    for (final int number : numbers) {
      queue.offer(number);
    }

    int[] result = new int[k];
    for (int i = 0; k > 0; i++, k--) {
      result[i] = queue.poll();
    }
    return result;
  }

  static int[] getLeastNumbers2(int[] numbers, int k) {
    if (numbers == null || k <= 0 || k >= numbers.length) {
      throw new IllegalArgumentException();
    }

    int start = 0;
    int end = numbers.length - 1;
    int index = partition(numbers, start, end);
    while (index != k - 1) {
      if (index > k - 1) {
        end = index - 1;
      } else {
        start = index + 1;
      }

      index = partition(numbers, start, end);
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = numbers[i];
    }
    return result;
  }

  static int partition(int[] numbers, int lo, int hi) {
    int p = numbers[lo];

    int i = lo + 1, j = hi;
    while (i < j) {
      while (numbers[i] < p && i < j) {
        i++;
      }
      while (numbers[j] > p && j > 0) {
        j--;
      }

      if (i < j) {
        swap(numbers, i, j);
      }
    }

    swap(numbers, j, lo);
    return j;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
