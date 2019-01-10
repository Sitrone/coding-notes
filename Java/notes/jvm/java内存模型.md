## java内存模型(jsr133) 
Java内存模型本身是一种抽象的概念，并不真实存在，它描述的是一组规则或规范，通过这组规范定义了程序中各个变量（包括实例字段，静态字段和构成数组对象的元素）的访问方式  

每个线程都有自己的工作内存，然后他们共享一个主内存。主存中的变量可以被拷贝到线程的工作内存中去单独执行，在执行结束后，结果可以在某个时间刷回主存   

Java的多线程之间是通过共享内存进行通信的，而由于采用共享内存进行通信，在通信过程中会存在一系列如可见性、原子性、顺序性等问题，也就是说默认情况下，不能保证任意时刻的数据一致性，但是通过对 synchronized、volatile 和 final 这几个语义被增强的关键字的使用，可以做到数据一致性。  

![jmm-1](..\..\pic\jmm-1.png)  

#### Java内存模型的承若 

重要的三个概念，原子性，有序性和可见性





* `JMM`中的**`happens-before`**原则:  

> 如果任何时候在满足以下这样两个条件的情况下，对一个对象的读操作 r，都能得到对于对象的写操作 w 的结果（读的时候要能返回写的结果），我们就认为它就是满足 happens-before 一致性的

1. 在同一个线程里面，按照代码执行的顺序（也就是代码语义的顺序），前一个操作先于后面一个操作发生
2. 对一个 monitor 对象的解锁操作先于后续对同一个 monitor 对象的锁操作
3. 对 volatile 字段的写操作先于后面的对此字段的读操作
4. 对线程的 start 操作（调用线程对象的 start() 方法）先于这个线程的其他任何操作
5. 一个线程中所有的操作先于其他任何线程在此线程上调用 join() 方法
6. 如果 A 操作优先于 B，B 操作优先于 C，那么 A 操作优先于 C 




### Ref 
1. [Java 多线程发展简史](http://www.raychase.net/698) 
2. [从 DCL 的对象安全发布谈起](http://www.raychase.net/1887) 
3. [The "Double-Checked Locking is Broken" Declaration](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html)
4. [全面理解Java内存模型(JMM)及volatile关键字](https://blog.csdn.net/javazejian/article/details/72772461)
5. 