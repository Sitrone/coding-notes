### MySQL InnoDB锁

#### 类型

1. [Shared and Exclusive Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-shared-exclusive-locks) 共享与排它锁，行级锁
2. [Intention Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-intention-locks) 意向锁，未来的某个时刻，事务可能要加共享/排它锁了，**先提前声明一个意向**；它是表级别锁
   * **意向共享锁**：它预示着，事务有意向对表中的某些行加共享S锁
   * **意向排它锁**：它预示着，事务有意向对表中的某些行加排它X锁
3. [Record Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-record-locks) 记录锁，封锁索引记录
4. [Gap Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-gap-locks) 间隙锁，封锁索引记录中的间隔
5. [Next-Key Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-next-key-locks)临建锁，记录锁与间隙锁的组合，它的封锁范围，既包含索引记录，又包含索引区间
6. [Insert Intention Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-insert-intention-locks) 插入意向锁，专门针对insert操作的，来提高insert操作的并发度
7. [AUTO-INC Locks](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-auto-inc-locks) 自增锁，表级别锁，专门针对事务插入AUTO_INCREMENT类型的列
8. [Predicate Locks for Spatial Indexes](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html#innodb-predicate-locks) 空间索引预测锁



### CRUD操作分别加什么锁

* `select`
  * 不加锁select使用快照读
  * 加锁模式，如果在唯一索引上面使用记录锁，在非唯一索引上面使用间隙锁与临建锁
* `update`与`delete`
  * 唯一索引上面，使用记录锁
  * 符合查询条件的索引记录，排他临建锁

* `insert` 
  * 用排它锁封锁被插入的索引记录
  * 插入区间加插入意向锁

### Reference

1. [InnoDB Locking](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html) 
2. [架构师之路 - 别废话，各种SQL到底加了什么锁？](https://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=2651961508&idx=1&sn=9f31a95e5b8ec16fa0edc7de6087d2a1&chksm=bd2d0d788a5a846e3bf16d300fb9723047bd109fd22682c39bdf7ed4e77b167e333460f6987c&scene=21#wechat_redirect)