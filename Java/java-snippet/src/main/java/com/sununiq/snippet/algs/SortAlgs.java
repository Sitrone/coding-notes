package com.sununiq.snippet.algs;

import java.util.Arrays;

/**
 * 排序算法
 **/
public class SortAlgs {

  public static void main(String[] args) {
    Integer[] arr = new Integer[]{7, 5, 6, 4};
    new SortAlgs().mergeSort(arr);

    System.out.println(Arrays.toString(arr));
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
      } else if (oriArray[i].compareTo(oriArray[j]) > 0) {
        nums[k] = oriArray[j++];
      } else {
        nums[k] = oriArray[i++];
      }
    }
  }
}
