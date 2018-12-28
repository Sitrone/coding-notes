package com.sununiq.snippet.gof.rpc.simple;

import com.sununiq.snippet.gof.rpc.simple.service.HelloService;
import com.sununiq.snippet.gof.rpc.simple.service.HelloServiceImpl;

/**
 *
 **/
public class RpcProvider {
  public static void main(String[] args) throws Exception {
    HelloService service = new HelloServiceImpl();
    RpcFramework.export(service, 1234);
  }
}
