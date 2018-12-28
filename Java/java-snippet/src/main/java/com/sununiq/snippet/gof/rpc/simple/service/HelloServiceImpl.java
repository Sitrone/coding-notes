package com.sununiq.snippet.gof.rpc.simple.service;

/**
 *
 **/
public class HelloServiceImpl implements HelloService {
  @Override
  public String hello(String name) {
    return "Hello " + name;
  }
}
