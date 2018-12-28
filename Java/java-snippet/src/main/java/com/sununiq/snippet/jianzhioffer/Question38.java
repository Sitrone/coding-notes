package com.sununiq.snippet.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 *  数字在排序数组中出现的次数
 *  1. hashMap
 *  2. 对于排序好的，可以使用二分查找
 **/
public class Question38 {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
    System.out.println(times(arr, 3));
  }

  static int times(int[] nums, int k) {
    if (nums == null || !contains(nums, k)) {
      throw new IllegalArgumentException();
    }


    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (final int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getKey() == k) {
        return entry.getValue();
      }
    }

    return 0;
  }

  static boolean contains(int[] nums, int k) {
    for (final int num : nums) {
      if (num == k) {
        return true;
      }
    }
    return false;
  }
}
