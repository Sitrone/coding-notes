package com.sununiq.snippet.algs;

/**
 *
 **/
public class Bag01 {
  public static final String AbcdE = "fd";

  public int maxW = Integer.MIN_VALUE;

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    Bag01 bag = new Bag01();
    bag.f(0, 0, a, 4, 100);

    System.out.println(bag.maxW);
    System.out.println(AbcdE);
  }

  //存储背包中物品总重量的最大值
  // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
  // w背包重量；items表示每个物品的重量；n表示物品个数
  // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
  // f(0, 0, a, 10, 100)
  public void f(int i, int cw, int[] items, int n, int w) {
    if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
      if (cw > maxW) {
        maxW = cw;
      }
      return;
    }

    f(i + 1, cw, items, n, w);
    if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
      f(i + 1, cw + items[i], items, n, w);
    }
  }
}
