package com.sununiq.snippet.algs;

/**
 *
 **/
public class Regex {
  public static void main(String[] args) {
    String s = "abc";
    String p = "a*c";
    System.out.println(match1(s, p));
  }

  /**
   * leetcode 10
   * 实现正则表达式中的.和*的匹配功能
   * ".": 匹配任意一个字符串1次
   * "*": 匹配0个或多个前一个字符串
   *
   * 只需要注意后一个字符是否为*即可，
   * 第一个字符直接进行对比判断，当第二个字符为*时，有2种情况
   *
   *   0个字符匹配，模式直接往后跳2位
   *   1个字符匹配，字符串往后跳1位
   * 没*的话直接对比匹配即可
   * @param s
   * @param p
   * @return
   */
  public static boolean match1(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
    if (p.length() >= 2 && p.charAt(1) == '*') {
      return match1(s, p.substring(2)) || (firstMatch && match1(s.substring(1), p));
    } else {
      return firstMatch && match1(s.substring(1), p.substring(1));
    }
  }

  /**
   * 通配符匹配 TODO 目前解法有问题
   * "?": 匹配任意一个字符1次
   * "#": 匹配任意一个字符0次或1次
   * "*": 匹配任意字符0次或任意多次
   * @param s
   * @param p
   * @return
   */
  public static boolean match2(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    return false;
  }
}
