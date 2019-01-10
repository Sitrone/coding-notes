package com.sununiq.snippet.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class DecodeWays91 {

  public static void main(String[] args) {
    System.out.println(new DecodeWays91().numDecodings("102213"));
  }

  private Map<String, Integer> map = new HashMap<>();
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
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
    Integer prefix = Integer.valueOf(s.substring(0, 2));
    if (prefix <= 26) {
      w += ways(s.substring(2));
    }

    map.put(s, w);
    return w;
  }
}
