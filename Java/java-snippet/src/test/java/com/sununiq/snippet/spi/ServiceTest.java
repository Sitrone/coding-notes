package com.sununiq.snippet.spi;

import org.junit.Test;

import com.sununiq.snippet.spi.service.Animal;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.ServiceLoader;

public class ServiceTest {
  private static final String PREFIX = "META-INF/services/";

  @Test
  public void serve() throws Exception {
    //        testJavaSPI();
//        testLoadAllServiceConfigs();

    testCustomServiceLoader();
  }

  @Test
  public void testSpi() throws ClassNotFoundException {
    Class.forName("com.java.service.EntityProvider");

    Service s = ServiceManager.newInstance("EntityService");
    s.serve();
  }

  /**
   * 测试自定义的ServiceLoader
   *
   * @throws Exception
   */
  private static void testCustomServiceLoader() throws Exception {
    List<Animal> animals = CustomServiceLoader.load(Animal.class);
    for (Animal animal : animals) {
      animal.eat();
    }
  }

  /**
   * 加载所有jar包下面指定路径的文件
   */
  private static void testLoadAllServiceConfigs() throws ClassNotFoundException, IOException {
    // 加载所有的jar包下面的这个路径下的这个约定文件
    // 然后加载文件中的类全名
    Class<?> service = Class.forName("com.sununiq.snippet.spi.service.Animal");
    String fullName = PREFIX + service.getName();
    Enumeration<URL> configs = ClassLoader.getSystemResources(fullName);
    while (configs.hasMoreElements()) {
      System.out.println(configs.nextElement());
    }
  }

  /**
   * 测试Java spi机制 系统的ServiceLoader通过返回一个Iterator对象能够做到对服务实例的懒加载 只有当调用iterator.next()方法时才会实例化下一个服务实例，只有需要使用的时候才进行实例化
   */
  private static void testJavaSPI() {
    // serviceLoader:首先根据约定的包获取到对应的接口文件，接着解析出文件中的所有服务实现类并加载实例化。
    ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
    for (final Animal animal : load) {
      animal.eat();
    }
  }
}