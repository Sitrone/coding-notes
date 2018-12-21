## jsr166 
引入java.util.concurrent包  

lock-free算法的基石CAS  

* CAS 
三个参数，一个当前内存值V、旧的预期值A、即将更新的值B，当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false 

问题：ABA问题 
解决方法：引入版本变量，如jdk中的这个类`AtomicStampedReference`  

![concurrent-1](..\..\pic\concurrent-1.png)   

### 线程池 
1. 请求到来首先交给 coreSize 内的常驻线程执行
2. 如果 coreSize 的线程全忙，任务被放到队列里面
3. 如果队列放满了，会新增线程，直到达到 maxSize
4. 如果还是处理不过来，会把一个异常扔到 RejectedExecutionHandler 中去，用户可以自己设定这种情况下的最终处理策略  

对于大于 coreSize 而小于 maxSize 的那些线程，空闲了 keepAliveTime 后，会被销毁  