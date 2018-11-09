package com.sununiq.snippet.util;

import java.lang.reflect.Array;

public final class ArrayUtils {
  /**
   * 1. 首先获取数组的类的对象
   * 2. 确认是一个数组
   * 3. 使用Class类（只能定义表示数组的类对象）的getComponentType方法确定数组对应的类型
   */
  public static Object copyOf(Object a, int newLen) {
    Class<?> cl = a.getClass();
    if (!cl.isArray()) {
      return null;
    }
    Class<?> componentType = cl.getComponentType();
    int len = Array.getLength(a);
    Object newArray = Array.newInstance(componentType, newLen);
    System.arraycopy(a, 0, newArray, 0, Math.min(len, newLen));

    return newArray;
  }
}
