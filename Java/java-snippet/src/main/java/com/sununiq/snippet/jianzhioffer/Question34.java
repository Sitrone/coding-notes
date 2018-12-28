package com.sununiq.snippet.jianzhioffer;

/**
 * 丑数
 * 从1开始的10个丑数分别为1，2，3，4，5，6，8，9，10，12
 **/
public class Question34 {

  public static void main(String[] args) {
    System.out.println(getUgly2(1500));
  }

  /**
   * 暴力解法，从1开始判断每一个数是否是uglyNumber
   */
  static int getUgly(int index) {
    if (index < 0) {
      return -1;
    }

    int number = 0;
    int uglyFound = 0;
    while (uglyFound < index) {
      ++number;
      if (isUgly(number)) {
        uglyFound++;
      }
    }

    return number;
  }

  static boolean isUgly(int number) {
    while (number % 2 == 0) {
      number /= 2;
    }
    while (number % 3 == 0) {
      number /= 3;
    }
    while (number % 5 == 0) {
      number /= 5;
    }

    return number == 1;
  }

  static int getUgly2(int index) {
    if (index < 0) {
      return -1;
    }

    int[] uglyNumbers = new int[index];
    uglyNumbers[0] = 1;
    int uglyIndex = 1;
    int p2 = 0, p3 = 0, p5 = 0;

    while (uglyIndex < index) {
      int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);

      uglyNumbers[uglyIndex] = min;

      // 找到已经找到的丑数分别乘以2，3，5里面刚好大于已知最大丑数的数，再去比较这三个最大的数，取最小值
      int curMax = min;
      while (uglyNumbers[p2] * 2 <= curMax) {
        p2++;
      }
      while (uglyNumbers[p3] * 3 <= curMax) {
        p3++;
      }
      while (uglyNumbers[p5] * 5 <= curMax) {
        p5++;
      }

      uglyIndex++;
    }

    return uglyNumbers[index - 1];
  }

  private static int min(int n1, int n2, int n3) {
    int min = n1 < n2 ? n1 : n2;
    return min < n3 ? min : n3;
  }
}
