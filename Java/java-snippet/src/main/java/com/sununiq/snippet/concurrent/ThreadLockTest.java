package com.sununiq.snippet.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程协作按顺序打印数字 ref: http://wcong.github.io/java/2015/07/25/java-synchronizer.html
 *
 * @author Administrator
 */
public class ThreadLockTest implements Runnable {

  public static int num = 1;

  public static int thread = 1;

  private int threadNum = thread++;

  private static ReentrantLock lock = new ReentrantLock();

  public static Condition condition1 = lock.newCondition();

  public static Condition condition2 = lock.newCondition();

  public static Condition condition3 = lock.newCondition();

  private Condition currentCondition;

  private Condition nextCondition;

  public ThreadLockTest(Condition myCondition, Condition nextCondition) {
    this.currentCondition = myCondition;
    this.nextCondition = nextCondition;
  }

  @Override
  public void run() {
    lock.lock();
    try {
      while (num <= 30) {
        for (int i = 0; i < 3; i++) {
          System.out.println(threadNum + ":" + num++);
        }
        nextCondition.signal();
        currentCondition.await();
      }
      // 执行完毕，全部唤醒，等待线程执行完毕
      nextCondition.signal();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] argv) {
    ThreadLockTest task1 = new ThreadLockTest(condition1, condition2);
    ThreadLockTest task2 = new ThreadLockTest(condition2, condition3);
    ThreadLockTest task3 = new ThreadLockTest(condition3, condition1);

    ExecutorService service = Executors.newFixedThreadPool(3);
    service.submit(task1);
    service.submit(task2);
    service.submit(task3);
    service.shutdown();
  }
}
