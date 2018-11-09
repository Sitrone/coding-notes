package com.sununiq.snippet.spi;

public interface Provider {
  // 服务提供者接口，返回提供的服务
  Service newService();
}
