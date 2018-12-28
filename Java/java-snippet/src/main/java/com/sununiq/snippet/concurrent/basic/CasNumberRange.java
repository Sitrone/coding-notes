package com.sununiq.snippet.concurrent.basic;

import com.sununiq.snippet.concurrent.basic.annotation.TheadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ref: https://stackoverflow.com/questions/3964211/when-to-use-atomicreference-in-java
 */
@TheadSafe
public class CasNumberRange {
  private final AtomicReference<IntPair> values = new AtomicReference<IntPair>(new IntPair(0, 0));

  public int getLower() {
    return values.get().lower;
  }

  public void setLower(int i) {
    while (true) {
      IntPair oldv = values.get();
      if (i > oldv.upper) {
        throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
      }
      IntPair newv = new IntPair(i, oldv.upper);
      if (values.compareAndSet(oldv, newv)) {
        return;
      }
    }
  }

  public int getUpper() {
    return values.get().upper;
  }

  // similarly for setUpper
  public void setUpper(int i) {
    while (true) {
      IntPair oldv = values.get();
      if (i < oldv.lower) {
        throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
      }
      IntPair newv = new IntPair(i, oldv.upper);
      if (values.compareAndSet(oldv, newv)) {
        return;
      }
    }
  }

  // Immutable
  private static class IntPair {
    final int lower; // Invariant: lower <= upper
    final int upper;

    public IntPair(int lower, int upper) {
      this.lower = lower;
      this.upper = upper;
    }
  }
}
