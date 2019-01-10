package com.sununiq.snippet.algs;

import java.util.Arrays;

/**
 * 排序算法
 **/
public class SortAlgs {

  public static void main(String[] args) {
    Integer[] arr = new Integer[]{7, 5, 6, 4};
//    new SortAlgs().mergeSort(arr);
    new SortAlgs().quickSort(arr);

//    new SortAlgs().insertSort(arr);

    System.out.println(Arrays.toString(arr));
  }

  public void insertSort(Comparable[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    for (int i = 1; i < nums.length; i++)
      for (int j = i; j > 0; j--) {
        if (less(nums[j], nums[j - 1])) {
          swap(nums, j, j - 1);
        }
      }
  }

  public void quickSort(Comparable[] nums) {
    doQuickSort(nums, 0, nums.length - 1);
  }

  private void doQuickSort(Comparable[] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int p = partition(nums, lo, hi);
    doQuickSort(nums, lo, p - 1);
    doQuickSort(nums, p + 1, hi);
  }

  private int partition(final Comparable[] nums, final int lo, final int hi) {
    Comparable posix = nums[lo];
    int i = lo, j = hi + 1;

    while (true) {
      while (less(nums[++i], posix) ) {
        if (i == hi) break;
      }
      while (less(posix, nums[--j])) { }
      if (i >= j) {
        break;
      }

      swap(nums, i, j);
    }

    swap(nums, lo, j);
    return j;
  }

  public void mergeSort(Comparable[] nums) {
    int start = 0;
    int end = nums.length - 1;
    Comparable[] oriArray = new Comparable[nums.length];

    mergeSort(nums, oriArray, start, end);
  }

  private void mergeSort(Comparable[] nums, Comparable[] ori, int start, int end) {
    if (start >= end) {
      return;
    }

    int mid = start + (end - start) / 2;
    mergeSort(nums, ori, start, mid);
    mergeSort(nums, ori, mid + 1, end);
    merge(nums, ori, start, mid, end);
  }

  private void merge(Comparable[] nums, Comparable[] oriArray, int start, int mid, int end) {
    int i = start, j = mid + 1;
    System.arraycopy(nums, start, oriArray, start, end - start + 1);

    for (int k = start; k <= end; k++) {
      if (i > mid) {
        nums[k] = oriArray[j++];
      } else if (j > end) {
        nums[k] = oriArray[i++];
      } else if (less(oriArray[j], oriArray[i])) {
        nums[k] = oriArray[j++];
      } else {
        nums[k] = oriArray[i++];
      }
    }
  }

  private boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private void swap(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
