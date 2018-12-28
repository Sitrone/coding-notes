package com.sununiq.snippet.jianzhioffer;

/**
 *
 **/
public class Question42 {
  public static void main(String[] args) {
    String s = "I am a student.";
    String reversed = reverse(s);
    System.out.println(reversed);
  }

  static String reverse(String source) {
    String[] strings = source.split(" ");
    StringBuilder builder = new StringBuilder(source.length());
    for (int i = strings.length - 1; i >= 0; i--) {
      builder.append(strings[i])
             .append(' ');
    }
    return builder.substring(0, builder.length() - 1);
  }
}
