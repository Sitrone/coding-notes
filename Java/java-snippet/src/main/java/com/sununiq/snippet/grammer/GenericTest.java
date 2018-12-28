package com.sununiq.snippet.grammer;

/**
 * Created by Administrator on 2017/7/16.
 */
public class GenericTest {
  public static void main(String[] args) {
    // 数组是协变的，意味着如果Sub是Super的子类型，则数组类型Sub[]就是Super[]的子类型
    // 泛型则是不可变的
    Object[] objectArray = new Long[1];
    objectArray[0] = "Hello world.";

    //        List<Object> objectList = new ArrayList<Long>(); // Incompatiable types
    //        objectList.add("Hello world.");

    // 泛型数组是不安全的
    //        List<String>[] stringLists = new ArrayList<String>[1];
    //        List<Integer> intList = Arrays.asList(42);
    //        Object[] objects = stringLists;
    //        objects[0] = intList;
    //        String s = stringLists[0].get(0);
  }
}

