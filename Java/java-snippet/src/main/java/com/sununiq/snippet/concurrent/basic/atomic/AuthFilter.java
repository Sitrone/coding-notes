package com.sununiq.snippet.concurrent.basic.atomic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public class AuthFilter {
  private static final int MAX_FAILED_TIMES = 3;
  private static final long MAX_LOCKED_TIME = 10 * 60 * 1000;
  private static ConcurrentMap<String, AtomicReference<AuthStatus>> userAuthMap = new ConcurrentHashMap<>();

  public void handleFailedAuth(String userName) {
    AtomicReference<AuthStatus> oldAuthStatus = userAuthMap.get(userName);
    while (true) {
      AuthStatus old = oldAuthStatus.get();
      if (old == null) {
        AuthStatus newAuthStatus = new AuthStatus(userName, 1, getNowTime(), 0, false);
        if (oldAuthStatus.compareAndSet(old, newAuthStatus)) {
          return;
        }
      }

      int failedTimes = old.getFailedTimes();
      failedTimes++;
      long firstFailedTime = old.getFirstFailedTime();
      long duration = getNowTime() - firstFailedTime;
      if (duration < MAX_LOCKED_TIME) {
        if (failedTimes < MAX_FAILED_TIMES) {
          AuthStatus newAuthStatus = new AuthStatus(userName, failedTimes, firstFailedTime, 0, false);
          if (oldAuthStatus.compareAndSet(old, newAuthStatus)) {
            return;
          }
        } else {
          AuthStatus newAuthStatus = new AuthStatus(userName, failedTimes, firstFailedTime, duration, true);
          if (oldAuthStatus.compareAndSet(old, newAuthStatus)) {
            return;
          }
        }
      } else {
        AuthStatus newAuthStatus = new AuthStatus(userName, 1, firstFailedTime, 0, false);
        if (oldAuthStatus.compareAndSet(old, newAuthStatus)) {
          return;
        }
      }
    }
  }

  private long getNowTime() {
    return System.currentTimeMillis();
  }
}
