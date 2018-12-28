package com.sununiq.snippet.jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

public class Question44Test {

  @Test
  public void testIsContinuous() {
    int[] numbers1 = {1, 3, 2, 5, 4}; // true
    Assert.assertTrue(Question44.isContinuous(numbers1));

    int[] numbers2 = {1, 3, 2, 6, 4}; // false
    Assert.assertFalse(Question44.isContinuous(numbers2));

    int[] numbers3 = {0, 3, 2, 6, 4}; // true
    Assert.assertTrue(Question44.isContinuous(numbers3));

    int[] numbers4 = {0, 3, 1, 6, 4};  // false
    Assert.assertFalse(Question44.isContinuous(numbers4));

    int[] numbers5 = {1, 3, 0, 5, 0};  // true
    Assert.assertTrue(Question44.isContinuous(numbers5));

    int[] numbers6 = {1, 3, 0, 7, 0}; // false
    Assert.assertFalse(Question44.isContinuous(numbers6));

    int[] numbers7 = {1, 0, 0, 5, 0}; // false
    Assert.assertFalse(Question44.isContinuous(numbers7));

    int[] numbers8 = {1, 0, 0, 7, 0}; // false
    Assert.assertFalse(Question44.isContinuous(numbers8));

    int[] numbers9 = {3, 0, 0, 0, 0};  // false
    Assert.assertFalse(Question44.isContinuous(numbers9));

    int[] numbers10 = {0, 0, 0, 0, 0}; // false
    Assert.assertFalse(Question44.isContinuous(numbers10));

    int[] numbers11 = {1, 0, 0, 1, 0}; // false
    Assert.assertFalse(Question44.isContinuous(numbers11));
  }
}