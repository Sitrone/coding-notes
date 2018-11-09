### SPI(Service Provider Service)  
> 服务提供者框架是指：  
多个服务提供者实现一个服务，系统为客户端提供多个实现，并把他们从多个实现中解耦出来。服务提供者的改变对它们的客户端是透明的，这样提供了更好的可扩展性。例如，JDBC，JMS等就是用了服务提供者框架     
<br>

通常有四个组件：
* ```Service Interface```：服务接口，将服务通过抽象统一声明，供客户端调用、由各个服务提供者具体实现。
* ```Provider Registration API```：服务提供者注册API，用于系统注册服务提供者，使得客户端可以访问它实现的服务。
* ```Service Access API```：服务访问API，用户客户端获取相应的服务。
* ```Service Provider Interface```：服务提供者接口，这些服务提供者负责创建其服务实现的实例。(可选）


应用场景,The concept can be extended to other platforms using the corresponding tools. In the Java Runtime Environment, SPIs are used in:

* ```Java Database Connectivity```
* ```Java Cryptography Extension```
* ```Java Naming and Directory Interface```
* ```Java API for XML Processing```
* ```Java Business Integration```
* ```Java Sound```
* ```Java Image I/O```
* ```Java File Systems```

<br>  
#### Reference:
1. [Difference between SPI and API?](http://stackoverflow.com/questions/2954372/difference-between-spi-and-api)
2. [服务提供者框架（Service Provider Framework）](http://blog.csdn.net/zl3450341/article/details/7227197)
3. [JAVA 服务提供者框架介绍](http://liwenshui322.iteye.com/blog/1267202) (关系图画的有问题)
4. Effective Java(Second Edition, Item 1)
