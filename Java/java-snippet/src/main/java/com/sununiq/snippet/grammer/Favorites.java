package com.sununiq.snippet.grammer;

import java.util.HashMap;
import java.util.Map;

/**
 * 「Effectiv Java」Item 29 优先考虑类型安全的异构容器 Created by Administrator on 2017/7/16.
 */
public class Favorites {
  /**
   * 两个局限性：
   * 1. 恶意客户端可以轻松破坏Favorites实例的类型安全，只要以它的原生态形式使用Class对象
   * 2. 它不能用在不可具体化(non-refiliable)的类型中, 例如不能保存List<String>
   */
  private Map<Class<?>, Object> favorites = new HashMap<>();

  public <T> void putFavorites(Class<T> type, T instance) {
    if (type == null) {
      throw new NullPointerException("Type is null");
    }
    favorites.put(type, type.cast(instance));
  }

  public <T> T getFavorites(Class<T> type) {
    return type.cast(favorites.get(type));
  }

  public static void main(String[] args) {
    Favorites favorites = new Favorites();
    favorites.putFavorites(String.class, "Java");
    favorites.putFavorites(Integer.class, 123);
    favorites.putFavorites(Class.class, Favorites.class);

    String favoritesString = favorites.getFavorites(String.class);
    int favoritesInt = favorites.getFavorites(Integer.class);
    Class<?> favoritesClass = favorites.getFavorites(Class.class);
    System.out.printf("%s %x %s/n", favoritesString, favoritesInt, favoritesClass);
  }
}
