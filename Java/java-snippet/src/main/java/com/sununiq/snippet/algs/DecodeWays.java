package com.sununiq.snippet.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 91 编码方式
 **/
public class DecodeWays {

  public static void main(String[] args) {
    System.out.println(new DecodeWays().decodeWays("102213"));
    System.out.println("".length());
  }

  // 递归的方式，eg：ways(102213) = ways(02213) + ways(2213)
  private Map<String, Integer> map = new HashMap<>();
  public int decodeWays(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    map.put("", 1);
    return ways(s);
  }

  private int ways(final String s) {
    if (map.containsKey(s)) {
      return map.get(s);
    }

    if (s.charAt(0) == '0') {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    int w = ways(s.substring(1));
    int prefix = Integer.parseInt(s.substring(0, 2));
    if (prefix <= 26) {
      w += ways(s.substring(2));
    }

    map.put(s, w);
    return w;
  }
}
