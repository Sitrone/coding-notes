package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1、J为11、Q为12、K为13。小王可以看成任意数字
 **/
public class Question44 {

  static boolean isContinuous(int[] nums) {
    if (nums == null || nums.length != 5) {
      throw new IllegalArgumentException();
    }

    Arrays.sort(nums);
    int numOfZero = 0, numOfGap = 0;
    if (nums[0] == 0) {
      numOfZero++;
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 0) {
        numOfZero++;
      } else if (nums[i - 1] == 0) {
      } else if (nums[i] - nums[i - 1] == 2) {
        numOfGap++;
      } else if (nums[i] - nums[i - 1] == 1) {
      } else {
        return false;
      }
    }

    if (numOfZero > 2) {
      return false;
    }

    return numOfGap == numOfZero;
  }
}
