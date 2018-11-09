package com.sununiq.snippet.spi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ServiceManager {


  // 把服务接口的名字映射到Services中
  private static final ConcurrentMap<String, Provider> PROVIDERS = new ConcurrentHashMap<>();

  private static final String DEFAULT_PROVIDER_NAME = "<def>";

  /**
   * 服务提供者注册API(默认)
   * @param p
   */
  public static void registerDefaultProvider(Provider p) {
    registerProvider(DEFAULT_PROVIDER_NAME, p);
  }

  /**
   * 服务提供者注册API
   */
  public static void registerProvider(String name, Provider p) {
    PROVIDERS.put(name, p);
  }

  /**
   * 服务访问API(默认)
   * @return
   */
  public static Service newInstance() {
    return newInstance(DEFAULT_PROVIDER_NAME);
  }

  /**
   * 服务访问API
   */
  public static Service newInstance(String name) {
    Provider p = PROVIDERS.get(name);
    if (p == null) {
      throw new IllegalArgumentException("No provider registered with name: " + name);
    }
    return p.newService();
  }
}
