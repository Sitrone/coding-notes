package com.sununiq.snippet.concurrent;

/**
 * 死锁，跳出程序的唯一办法就是终止jvm的运行
 **/
public class UnInterruptble {
  public static void main(String[] args) throws InterruptedException {
    final Object o1 = new Object();
    final Object o2 = new Object();

    Thread t1 = new Thread(() -> {
      synchronized (o1){
        try {
          Thread.sleep(1000);
          synchronized (o2){ }
        } catch (InterruptedException e) {
          System.out.println("t1 interrupted");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (o2){
        try {
          Thread.sleep(1000);
          synchronized (o1){ }
        } catch (InterruptedException e) {
          System.out.println("t2 interrupted");
        }
      }
    });

    t1.start();t2.start();
    Thread.sleep(2000);
    t1.interrupt();t2.interrupt();
    t1.join();t2.join();
  }


}
