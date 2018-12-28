package com.sununiq.snippet.jianzhioffer;

/**
 * 算一个只出现一次的字符
 *
 * map 来解决
 **/
public class Question35 {

  public static void main(String[] args) {
    String s = "abaccdeff";
    System.out.println(firstNonRepeatingChar(s));
  }

  static char firstNonRepeatingChar(String source) {
    int[] map = new int[256];
    for (int i = 0; i < map.length; i++) {
      map[i] = 0;
    }

    for (final char c : source.toCharArray()) {
      map[c] += 1;
    }

    for (int i = 0; i < map.length; i++) {
      if (map[i] == 1) {
        return (char) i;
      }
    }

    throw new IllegalArgumentException();
  }
}
