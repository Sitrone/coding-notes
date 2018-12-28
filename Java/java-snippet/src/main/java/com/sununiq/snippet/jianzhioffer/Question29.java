package com.sununiq.snippet.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数， 也就是中位数
 * 1. hashMap
 * 2. 先排序，再遍历
 * 3. 根据数组特点找
 * 4. 基于快排的partition来找中位数
 **/
public class Question29 {
  public static void main(String[] args) {

    int[] nums = new int[]{1, 2, 3, 2, 3, 4, 5, 4, 2};
    System.out.println(moreThanHalfNum(nums));
  }

  static int moreThanHalfNum(int[] numbers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (final int number : numbers) {
      if (map.containsKey(number)) {
        Integer value = map.get(number);
        map.put(number, value + 1);
      } else {
        map.put(number, 0);
      }
    }

    int key = 0;
    int max = 0;
    for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        key = entry.getKey();
        max = entry.getValue();
      }
    }
    return key;
  }

  static int moreThanHalfNum2(int[] numbers) {
    int result = numbers[0];
    int times = 1;

    for (int i = 1; i < numbers.length; i++) {
      if (times == 0) {
        result = numbers[i];
        times = 1;
      } else if (numbers[i] == result) {
        times++;
      } else {
        times--;
      }
    }
    return result;
  }
}
