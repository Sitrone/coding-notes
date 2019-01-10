package com.sununiq.snippet.algs;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * lru 缓存
 **/
public class LRU<K, V> {
  private Deque<K> list;
  private Map<K, V> map;
  private int size;

  public LRU(int cacheSize) {
    this.list = new LinkedList<>();
    this.map = new HashMap<>();
    this.size = cacheSize;
  }

  public V get(K k) {
    if (map.containsKey(k)) {
      V v = map.get(k);
      list.remove(k);
      list.addFirst(k);
      return v;
    }

    return null;
  }

  public void put(K k, V v) {
    if (map.containsKey(k)) {
      list.remove(k);
      map.remove(k);
    }

    if (list.size() >= size) {
      K last = list.getLast();
      list.removeLast();
      map.remove(last);
    }

    list.addFirst(k);
    map.put(k, v);
  }

  public int size() {
    return list.size();
  }

  public static class LRU1<K,V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRU1(final int cacheSize) {
      super(16, 0.75f, true);
      this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
      return size() >= cacheSize;
    }
  }

  public static void main(String[] args) {
    LRU<Integer, String> lru = new LRU<>(3);
    lru.put(1, "1");
    lru.put(2, "2");
    lru.put(3, "3");
    lru.put(4, "4");
    System.out.println(lru.get(1));
    System.out.println(lru.get(2));
    System.out.println(lru.list);
    System.out.println(lru.map);
  }
}
