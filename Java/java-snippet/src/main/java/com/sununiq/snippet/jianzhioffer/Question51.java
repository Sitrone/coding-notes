package com.sununiq.snippet.jianzhioffer;

/**
 * 原地替换，利用所有元素都在1 ~ (n-1)区间的特性
 **/
public class Question51 {

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 0, 2, 5, 3};
    System.out.println(hasDuplicate(arr));
    System.out.println(hasDuplicate0(arr));
  }

  static boolean hasDuplicate0(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    int[] copy = new int[nums.length];
    for (final int num : nums) {
      if (copy[num] != 0) {
        return true;
      }

      copy[num]++;
    }
    return false;
  }

  static boolean hasDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    for (int num : nums) {
      if (num < 0 || num >= nums.length) {
        return false;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i) {
        if (nums[i] == nums[nums[i]]) {
          return true;
        } else {
          swap(nums, i, nums[i]);
        }
      }
    }

    return false;
  }

  private static void swap(int[] nums, int x, int y) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }
}
