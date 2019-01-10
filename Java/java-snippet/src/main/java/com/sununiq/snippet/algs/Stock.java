package com.sununiq.snippet.algs;

import java.io.IOException;

/**
 *
 **/
public class Stock {
  public static void main(String[] args) throws IOException {
    int[] arr = {1, 3, 2, 8, 4, 9};
    int fee = 2;

    System.out.println(new Stock().maxProfit(arr, fee));

    arr = new int[]{1, 2, 1, 3, 5, 6, 4};

    System.out.println(findPeakElement(arr));

    arr = new int[]{1, 2, 3, 1};
    System.out.println(findPeakElement(arr));
    System.out.println(findPeakElement1(arr));

//    BitSet bitSet = new BitSet(5_000_000);
//    byte[] bytes = Files.readAllBytes(Paths.get(""));
//    String strings = new String(bytes, StandardCharsets.UTF_8);
//    String[] fields = strings.split(" ");
//    boolean ret = Arrays.asList(fields).contains("12345");
  }

  public int maxProfit(int[] prices, int fee) {
    int res = 0;
    int n = prices.length;

    if (n < 2) {
      return 0;
    }

    for (int i = 1; i < n; ++i) {
      if (prices[i] - prices[i - 1] > fee) {
        res += prices[i] - prices[i - 1] - fee;
      }
    }

    return res;
  }

  public static int findPeakElement1(int[] nums) {
    if (nums == null) {
      throw new IllegalArgumentException();
    }

    if (nums.length == 1) {
      return 0;
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        return i - 1;
      }
    }
    return nums.length - 1;
  }

  /**
   * 找到数组里面的波峰 二分法
   *
   * @param nums
   * @return
   */
  public static int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[mid + 1]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }



  /**
   * 递归二分搜索
   *
   * @param nums
   * @return
   */
  public static int findPeakElement2(int[] nums) {
    return search(nums, 0, nums.length - 1);
  }

  public static int search(int[] nums, int l, int r) {
    if (l == r) {
      return l;
    }

    int mid = (l + r) / 2;
    if (nums[mid] > nums[mid + 1]) {
      return search(nums, l, mid);
    }
    return search(nums, mid + 1, r);
  }
}
