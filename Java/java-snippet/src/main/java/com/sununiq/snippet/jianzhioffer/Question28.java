package com.sununiq.snippet.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BFS
 **/
public class Question28 {
  public static void main(String[] args) {
    String source = "abc";
    List<String> result = permutation(source);
    System.out.println(result);
  }

  static List<String> permutation(String source) {
    List<String> result = new ArrayList<>();
    if (source == null) {
      return result;
    }

    Stack<List<Character>> stack = new Stack<>();
    for (final char c : source.toCharArray()) {
      List<Character> temp = new ArrayList<>(source.length());
      temp.add(c);
      stack.push(temp);
    }

    while (!stack.isEmpty()) {
      List<Character> cur = stack.pop();
      if (cur.size() == source.length()) {
        result.add(convert2String(cur));
        continue;
      }

      for (final char c : source.toCharArray()) {
        if (!cur.contains(c)) {
          List<Character> temp = new ArrayList<>(cur);
          temp.add(c);
          stack.push(temp);
        }
      }
    }
    return result;
  }

  private static String convert2String(List<Character> list) {
    StringBuilder builder = new StringBuilder(list.size());
    for (final Character c : list) {
      builder.append(c);
    }
    return builder.toString();
  }
}