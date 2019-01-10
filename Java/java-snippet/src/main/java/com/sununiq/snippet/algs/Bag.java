package com.sununiq.snippet.algs;

import java.util.Stack;

/**
 * 总体积为T，n件物品体积分别是w1,w2,...,w2n，找出若干件恰好装满背包
 *
 * 解法：采用0-1背包的思想，使用递归方法：
 *
 * 　　当选择n时，就用剩下的n-1填满 m-n;
 *
 * 　　当不选择n是，就用剩下的n-1填满m；
 *
 * Ref: https://blog.csdn.net/guo8113/article/details/39434985
 **/
public class Bag {
  public static void main(String[] args) {
    int sum = 4;
    int[] nums = {1, 2, 3, 4};
    findSum(sum, nums);
  }

  private static Stack<Integer> stack = new Stack<>();

  public static void findSum(int sum, int[] nums) {
    findSum(sum, nums, 0);
  }

  private static void findSum(int sum, int[] nums, int index) {
    if (sum < 0 || (sum > 0 && index >= nums.length)) {
      return;
    }

    if (sum == 0) {
      System.out.println(stack);
      return;
    }

    stack.push(nums[index]);
    findSum(sum - nums[index], nums, index + 1);
    stack.pop();
    findSum(sum, nums, index + 1);
  }
}
