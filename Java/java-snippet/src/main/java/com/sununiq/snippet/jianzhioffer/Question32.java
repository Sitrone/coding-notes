package com.sununiq.snippet.jianzhioffer;

/**
 * 从1到n整数中1出现的次数
 * 1. 暴力解法
 * 2. 找规律 http://wangwlj.com/2018/03/06/coding_offer32_1toN/
 **/
public class Question32 {

  public static void main(String[] args) {
    int n = 21345;
    System.out.println(numberOf1Between1ToN2(n));
    System.out.println(numberOf1Between1ToN(n));
    System.out.println(numberOf1Between1ToN1(n));
  }

  /**
   * 拼接成字符串再判断, 最慢
   *
   * @param n
   * @return
   */
  static int numberOf1Between1ToN1(int n) {
    int count = 0;
    StringBuilder builder = new StringBuilder(n * n);
    for (int i = 0; i <= n; i++) {
      builder.append(i);
    }
    String str = builder.toString();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        count++;
      }
    }

    return count;
  }

  // 暴力法
  static int numberOf1Between1ToN(int n) {
    int count = 0;
    for (int i = 0; i <= n; i++) {
      count += numberOf1(i);
    }

    return count;
  }

  static int numberOf1Between1ToN2(int n) {
    int count = 0;//1的个数
    int i = 1;//当前位

    while ((n / i) != 0) {
      int current = (n / i) % 10; // 当前位数字
      int before = n / (i * 10); // 高位数字
      int after = n - (n / i) * i; // 低位数字

      //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
      if (current == 0) {
        count += before * i;
      }
      //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
      else if (current == 1) {
        count += before * i + after + 1;
      }
      //如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
      else {
        count += (before + 1) * i;
      }

      //前移一位
      i *= 10;
    }
    return count;
  }

  private static int numberOf1(int num) {
    int count = 0;
    while (num != 0) {
      if (num % 10 == 1) {
        count++;
      }
      num /= 10;
    }

    return count;
  }
}
