package com.sununiq.snippet.jianzhioffer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * 利用排序, 重新定义排序规则，最后顺序输出，注意是个隐形的大数问题
 **/
public class Question33 {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 32, 321};
    printMinNumber(arr);
  }

  static void printMinNumber(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return;
    }

    Integer[] nums = new Integer[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      nums[i] = numbers[i];
    }

    Arrays.sort(nums, (n1, n2) -> (n1 + "" + n2).compareTo(n2 + "" + n1));
    StringBuilder builder = new StringBuilder();
    for (final Integer num : nums) {
      builder.append(num);
    }
    System.out.println(builder.toString());
  }
}
