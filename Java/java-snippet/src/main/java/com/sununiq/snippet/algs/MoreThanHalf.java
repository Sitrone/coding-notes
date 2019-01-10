package com.sununiq.snippet.algs;

/**
 * 一个整数数组中，存在一个数字，重复次数超过一半，请把数字找出来，要求空间复杂度O(1)
 * <p>
 * 潜台词：中位数 1. hashMap  -- 排除 2. 先排序，再遍历  -- 排除 3. 根据数组特点找  可行 4. 基于快排的partition来找中位数
 **/
public class MoreThanHalf {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    System.out.println(moreThanHalf1(arr));
  }

  /**
   * 根据数组的特点找规律:
   * 根据题意可知：目标数字比所有其他数字出现的次数的和还多，因此要找的数字一定是最后一次把次数设为1的对应的数字
   * @param arr
   * @return
   */
  public static int moreThanHalf1(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException();
    }

    int times = 0;
    int ret = arr[0];
    for (int n : arr) {
      if (times == 0) {
        times = 1;
        ret = n;
      } else if (ret == n) {
        times++;
      } else {
        times--;
      }
    }

    checkMoreThanHalf(arr, ret);
    return ret;
  }

  /**
   * 使用基于快排里面的partition算法
   * @param arr
   * @return
   */
  public static int moreThanHalf(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException();
    }

    int lo = 0, hi = arr.length - 1, mid = arr.length >> 1;
    int index = partition(arr, lo, hi);
    while (index != mid) {
      if (index > mid) {
        index = partition(arr, lo, index - 1);
      } else {
        index = partition(arr, index + 1, hi);
      }
    }

    checkMoreThanHalf(arr, arr[index]);
    return arr[index];
  }

  private static int partition(int[] a, int lo, int hi) {
    //将数组切分为a[lo...i-1]、a[i] 和a[i+1...hi];
    int i = lo, j = hi + 1;
    int v = a[lo];
    while (true) {
      while (a[++i] < v) {
        if (i == hi) {
          break;
        }
      }
      while (v < a[--j]) { }

      if (i >= j) {
        break;
      }

      swap(a, i, j);
    }
    swap(a, lo, j);
    return j;
  }

  private static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  private static void checkMoreThanHalf(int[] arr, int n) {
    int times = 0;
    for (int i : arr) {
      if (i == n) {
        times++;
      }
    }

    if ((times << 1) < arr.length) {
      throw new IllegalArgumentException();
    }
  }
}
