![jvm内存结构](..\..\pic\jvm内存结构.png)

#### 堆(Heap)
* 线程共享
* 几乎所有的对象实例都在这里分配内存
* 为新生代和老年代，默认比例为1:2；其中新生代分为Eden，from，to，默认8:1:1比例

#### 方法区(Program Counter Register) 
* 线程共享
* 存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据

#### JVM栈 (Method Area) 
* 线程私有
* 每个方法被执行的时候都会创建一个栈帧，每一个方法被调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中从入栈到出栈的过程

#### 程序计数器 (JVM Stacks) 
* 线程私有
* 它的作用可以看做是当前线程所执行的字节码的行号指示器

#### 本地方法栈(Native Method Stacks) 
* 线程私有
* 为虚拟机使用到的Native方法服务 

### 关于永久代PermGen和元数据区MetaspaceSize 
* 方法区（method area）只是JVM规范中定义的一个概念，用于存储类信息、常量池、静态变量、JIT编译后的代码等数据，具体放在哪里，不同的实现可以放在不同的地方。而永久代是Hotspot虚拟机特有的概念，是方法区的一种实现，别的JVM都没有这个东西 
* 在Java 8中，永久代被彻底移除，取而代之的是另一块与堆不相连的本地内存——元空间（Metaspace）,‑XX:MaxPermSize 参数失去了意义，取而代之的是-XX:MaxMetaspaceSize

### 常见的出现`OutOfMemory`的情况
* 堆内存溢出
* java栈扩展时无法申请到足够的内存溢出
* 永久代或元数据区内存不够溢出
* 系统总内存不够，无法创建本地线程

### Ref 
1. [What Causes OutOfMemoryError?](https://dzone.com/articles/what-causes-outofmemoryerror) 
2. [jvm系列(二):JVM内存结构](http://www.ityouknow.com/jvm/2017/08/25/jvm-memory-structure.html) 
3. [方法区的Class信息,又称为永久代,是否属于Java堆？](https://www.zhihu.com/question/49044988)
