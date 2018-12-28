package com.sununiq.snippet.jianzhioffer;

/**
 * 数组中的逆序对
 * 1. 暴力解法，两层遍历
 * 2. 采用基于相邻元素交换的排序
 **/
public class Question36 {
  public static void main(String[] args) {
    int[] arr = new int[]{7, 5, 6, 4};

    System.out.println(invertedPairs(arr));

    System.out.println(invertedPairs2(arr));
  }

  // 暴力法，两重循环
  static int invertedPairs(int[] nums) {
    int total = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (nums[j] < nums[i]) {
          total += 1;
        }
      }
    }

    return total;
  }

  /**
   * 从逆序对的概念入手，一个在前的元素大于一个在后的元素即可组成逆序对。而一个排序好的数组逆序对数为0
   * 且必须使用基于相邻元素来统计交换次数，那么基于交换相邻元素的排序算法有冒泡排序，插入排序和归并排序
   * 其中只有归并排序的时间复杂度为线性对数复杂度
   */
  static int invertedPairs2(int[] nums) {
    int[] ori = new int[nums.length];
    return mergeSort(nums, ori, 0, nums.length - 1);
  }

  private static int mergeSort(int[] nums, int[] ori, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;
      int left = mergeSort(nums, ori, start, mid);
      int right = mergeSort(nums, ori, mid + 1, end);
      int count = merge(nums, ori, start, mid, end);
      return left + right + count;
    } else {
      return 0;
    }
  }

  private static int merge(int[] nums, int[] ori, int start, int mid, int end) {
    int result = 0, i = start, j = mid + 1;
    System.arraycopy(nums, start, ori, start, end - start + 1);

    for (int k = start; k <= end; k++) {
      if (i > mid) {
        nums[k] = ori[j++];
      } else if (j > end) {
        nums[k] = ori[i++];
      } else if (ori[i] > ori[j]) {
        nums[k] = ori[j];
        // 只有此处才能产生逆序对
        result += end - j + 1;
        j++;
      } else {
        nums[k] = ori[i++];
      }
    }

    return result;
  }
}
