package com.sununiq.snippet.leetcode;

/**
 * 正则表达式匹配
 **/
public class RegularExpression10 {
  public static void main(String[] args) {
    String s = "aab";
    String p = "c*a*b";
    System.out.println(isMatch(s, p));
  }


  public static boolean isMatch(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

    if (p.length() > 1 && p.charAt(1) == '*') {
      return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
    } else {
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }
}
