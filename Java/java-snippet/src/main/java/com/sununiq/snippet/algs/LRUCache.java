package com.sununiq.snippet.algs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class LRUCache<K, V> {
  private Map<K, Node<K, V>> map;
  private Node<K, V> dummy;
  private int cacheSize;

  public LRUCache(final int cacheSize) {
    this.cacheSize = cacheSize;
    this.dummy = new Node<>(null, null);
    this.dummy.next = dummy;
    this.dummy.pre = dummy;
    this.map = new HashMap<>();
  }

  public Node<K, V> get(K k) {
    if (map.containsKey(k)) {
      Node<K, V> node = map.get(k);
      remove(node);
      addFirst(node);
      return node;
    }

    return null;
  }

  public void put(K k, V v) {
    if (map.containsKey(k)) {
      Node<K, V> node = map.get(k);
      map.remove(k);
      remove(node);
    }

    if (map.size() >= cacheSize) {
      Node<K, V> last = dummy.pre;
      map.remove(last.k);
      remove(last);
    }

    Node<K, V> node = new Node<>(k, v);
    addFirst(node);
    map.put(k, node);
  }

  public int size() {
    return map.size();
  }

  private void remove(Node<K, V> node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  private void addFirst(Node<K, V> node) {
    node.next = dummy.next;
    node.pre = dummy;
    dummy.next.pre = node;
    dummy.next = node;
  }

  public static class Node<K, V> {
    public K k;
    public V v;
    public Node<K, V> pre;
    public Node<K, V> next;

    public Node(final K k, final V v) {
      this.k = k;
      this.v = v;
    }

    @Override
    public String toString() {
      return "Node{" +
          "k=" + k +
          ", v=" + v +
          '}';
    }
  }

  public static void main(String[] args) {
    LRUCache<Integer, String> lru = new LRUCache<>(3);
    lru.put(1, "1");
    lru.put(2, "2");
    lru.put(3, "3");
    lru.put(4, "4");
    System.out.println(lru.get(1));
    System.out.println(lru.get(2));
    System.out.println(lru.dummy);
    System.out.println(lru.map);
  }
}
