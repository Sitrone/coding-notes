package com.sununiq.snippet.concurrent.basic.atomic;

public final class AuthStatus {
  private final String userName;

  private final int failedTimes;

  private final long firstFailedTime;

  private final long lockedTime;

  private final boolean locked;

  public AuthStatus(String userName, int failedCount, long firstFailedTime, long lockedTime, boolean locked) {
    this.userName = userName;
    this.failedTimes = failedCount;
    this.firstFailedTime = firstFailedTime;
    this.lockedTime = lockedTime;
    this.locked = locked;
  }

  public String getUserName() {
    return userName;
  }

  public int getFailedTimes() {
    return failedTimes;
  }

  public long getFirstFailedTime() {
    return firstFailedTime;
  }

  public long getLockedTime() {
    return lockedTime;
  }

  public boolean isLocked() {
    return locked;
  }
}
