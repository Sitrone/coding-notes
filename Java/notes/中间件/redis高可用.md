###  集群模式 
多主，每个主节点可以配置多个从节点副本，Redis 集群没有使用一致性hash, 而是引入了 哈希槽的概念，每个key通过CRC16校验后对16384取模来决定放置哪个槽。

如三主三从，主节点到从节点的复制为异步方式，所以redis无法保证强一致性

* 优点 
1. 自动故障转移，slot迁移中数据可用
2. 官方维护，更新和支持有保障

* 缺点 
1. 扩容和收缩不够自动化需要执行脚本


### sentinel模式
redis做master-slave的高可用方案时候，master挂掉，自身无法进行主备切换，此时引入sentinel来做redis集群监控，可以操作redis主备切换。同时sentinel自身支持集群模式达到高可用
![redis-sentinel-2](..\..\pic\redis-sentinel-2.jpg) 


### Ref 
1. [Redis高可用简要梳理](https://zhuanlan.zhihu.com/p/34592063) 
2. 