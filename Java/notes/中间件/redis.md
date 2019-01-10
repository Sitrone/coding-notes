### redis 数据结构 

* String——字符串，最简单的k-v

  

* Hash——字典 

  应用：比如存储一个用户的信息，姓名、年龄和生日等

* List——列表，redis使用双端列表实现

  * 应用：1. timeline，2.实现消息队列，配合使用list的push和pop操作
  * 实现：当一个哈希键只包含少量键值对， 并且每个键值对的键和值要么就是小整数值， 要么就是长度比较短的字符串， 那么 Redis 就会使用压缩列表来做哈希键的底层实现，当存储的键值对超过一定的值就会转换为哈希表dict



* **渐进式rehash的步骤**:

1. 为ht[1]分配空间，让字典同时持有ht[0]和ht[1]两个哈希表
2. 维持索引计数器变量rehashidx，并将它的值设置为0，表示rehash开始
3. 每次对字典执行增删改查时，将ht[0]的rehashidx索引上的所有键值对rehash到ht[1]，将rehashidx值+1。
4. 当ht[0]的所有键值对都被rehash到ht[1]中，程序将rehashidx的值设置为-1，表示rehash操作完成

> 为了提高前移速度，Redis有一个周期性任务serverCron，每隔一段时间会迁移100个桶。  

进行增删改查的时候，如果不在rehash过程，则只在ht[0]中进行操作，否则先在ht[0]操作，没有命中再到ht[1]中操作



* Set——集合 

  应用：关注用户的粉丝，可以用redis提供的对几何的交、并和差集操作可以很方便的求粉丝的共同好友和二度好友等

* Sorted Set——有序集合

  * 应用：游戏用户的排分榜 
  * 实现：跳跃表（skiplist） 





> 跳跃表支持平均 O(log N) 最坏 O(N) 复杂度的节点查找， 还可以通过顺序性操作来批量处理节点



### redis pipeline

`Redis Pipelining`可以一次发送多个命令，并按顺序执行、返回结果，节省RTT(Round Trip Time)  





## 参考

1. [Redis 内存使用优化与存储](https://www.infoq.cn/article/tq-redis-memory-usage-optimization-storage )
2. [渐进式 rehash](http://redisbook.com/preview/dict/incremental_rehashing.html)
3. [【Redis深入】字典rehash图解](https://blog.csdn.net/baiye_xing/article/details/76088425)
4. [压缩列表](http://redisbook.com/preview/ziplist/content.html)
5. [Redis内部数据结构详解(4)——ziplist](http://zhangtielei.com/posts/blog-redis-ziplist.html)