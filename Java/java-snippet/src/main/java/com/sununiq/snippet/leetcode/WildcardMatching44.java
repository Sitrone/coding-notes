package com.sununiq.snippet.leetcode;

/**
 *
 **/
public class WildcardMatching44 {

  /**
   * '?' Matches any single character.
   * '*' Matches any sequence of characters (including the empty sequence).
   * @param s
   * @param p
   * @return
   */
  public static boolean isMatch(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    return false;

  }
}
