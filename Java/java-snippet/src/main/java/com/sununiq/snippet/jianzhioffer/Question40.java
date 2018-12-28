package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;

/**
 * 数组中两个只出现1次的数字，其他数字均出现2次
 * 要求时间复杂度O(n)，空间复杂度O(1)
 *
 * 1. 不考虑空间复杂度可以使用HashMap记录各个元素出现的次数
 * 2. 参照数组中有1个出现1次的数字的解法
 **/
public class Question40 {

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 6, 3, 2, 5, 5};
    System.out.println(Arrays.toString(onceNumberWithTwo(arr)));
  }

  /**
   * 数组中1个数字只出现一次，其余数字均出现2次
   * @param nums
   * @return
   */
  static int onceNumberWithOne(int[] nums) {
    if (nums == null) {
      return 0;
    }
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  /**
   * 想办法分成两组，每组各只包含1个出现1次的数字
   * 通过全部异或的结果的第n个不为0的位来分为两组，一组n位为0， 一组n位为1
   * @param nums
   * @return
   */
  static int[] onceNumberWithTwo(int[] nums) {
    if (nums == null) {
      return null;
    }

    int middleResult = onceNumberWithOne(nums);

    int firstBit1 = findFirstBit1(middleResult);

    int num1 = 0, num2 = 0;
    for (final int num : nums) {
      if (isBit1(num, firstBit1)) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }

    return new int[]{num1, num2};
  }

  private static boolean isBit1(int n, int firstBit1) {
    return ((n >>> firstBit1) & 0x1) == 1;
  }

  private static int findFirstBit1(int result) {
    int firstBit1 = 0;
    for (int i = 0; i < 32; i++) {
      if ((result & 0x1) == 1) {
        firstBit1 = i;
        break;
      } else {
        result >>>= 1;
      }
    }

    return firstBit1;
  }
}
