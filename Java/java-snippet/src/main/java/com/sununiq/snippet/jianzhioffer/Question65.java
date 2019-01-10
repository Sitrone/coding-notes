package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找到滑动窗口中最大值的集合
 **/
public class Question65 {
  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
    System.out.println(Arrays.toString(maxInWindow(arr, 3)));
    System.out.println(Arrays.toString(maxInWindow1(arr, 3)));
  }

  /**
   * 暴力法
   * 时间复杂度: O(size*n)
   * @param arr
   * @return
   */
  public static int[] maxInWindow(int[] arr, int size) {
    if (arr == null || arr.length < size) {
      throw new IllegalArgumentException();
    }

    int[] ret = new int[arr.length - size + 1];
    for (int i = 0, j = size - 1, k = 0; j < arr.length; i++, j++, k++) {
      ret[k] = findMax(arr, i, j);
    }
    return ret;
  }

  private static int findMax(int[] arr, int lo, int hi) {
    int max = arr[lo];
    for (int i = lo; i <= hi; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  /**
   * 使用大顶推解决 时间复杂度：O(logsize * n)
   *
   * @param arr
   * @return
   */
  public static int[] maxInWindow1(int[] arr, int size) {
    if (arr == null || arr.length < size) {
      throw new IllegalArgumentException();
    }

    int[] ret = new int[arr.length - size + 1];
    // 构建窗口为size的最大堆，即堆顶元素是堆的最大值。
    Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < size; i++) {
      heap.add(arr[i]);
    }

    ret[0] = heap.peek();
    for (int i = 1, k = 1; i < arr.length - size + 1; i++, k++) {
      heap.remove(arr[i - 1]);
      heap.add(arr[i + size - 1]);
      ret[k] = heap.peek();
    }

    return ret;
  }

  private static int findMax1(int[] arr, int lo, int hi) {
    int max = lo;
    for (int i = lo; i <= hi; i++) {
      if (arr[i] > arr[max]) {
        max = i;
      }
    }
    return max;
  }
}
