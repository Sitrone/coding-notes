package com.sununiq.snippet.spi;

public class SpecialServiceProvider implements Provider {

  static {
    ServiceManager.registerProvider("SpecialService", new SpecialServiceProvider());
  }

  @Override
  public Service newService() {
    return new SpecialServiceImpl();
  }
}
