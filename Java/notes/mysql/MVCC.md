## MySQL高并发 

### 并发控制常见手段

* 普通锁
* 读写锁，读读并行，其他互斥
* 乐观锁（CAS），解决写写冲突
* 数据多版本（MVCC），解决读写冲突

> 多版本并发控制（MVCC）是一种用来**解决读-写冲突**的无锁并发控制，也就是为事务分配单向增长的时间戳，为每个修改保存一个版本，版本与事务时间戳关联，读操作只读该事务开始前的数据库的快照。 这样在读操作不用阻塞写操作，写操作不用阻塞读操作的同时，避免了脏读和不可重复读
>
> 乐观并发控制（OCC）是一种用来**解决写-写冲突**的无锁并发控制，认为事务间争用没有那么多，所以先进行修改，在提交事务前，检查一下事务开始后，有没有新提交改变，如果没有就提交，如果有就放弃并重试。乐观并发控制类似自选锁。乐观并发控制适用于低数据争用，写冲突比较少的环境。
>
> 作者：用心阁
>
> 链接：https://www.zhihu.com/question/27876575/answer/71836010

### MVCC原理

1. 写任务发生，克隆数据，加上版本号区分

2. 写任务操作新克隆的数据直至提交

3. 读任务读取旧版本数据，不阻塞


### `redo`日志，`undo`日志，回滚段，`bin log`

#### `redo`日志

用于保障事务的原子性和持久性，InnoDB通过Force Log at Commit机制实现了事务的持久性，即当事务提交时，必须先将该事务的所有日志写入到redo log中进行持久化

存放在重做日志文件中

#### `undo`日志

用于事务的回滚操作，日志存放在数据库内部的一个特殊段，这个段叫做回滚段（`undo segment`）



#### 回滚段

1. 回滚事务
2. `MVCC`，`InnoDB`的`MVCC`通过`undo`来完成， 里面存放的其实是历史版本数据，继而实现 非锁定读取



#### `bin log`

* 用于复制，在主从复制中，从库利用主库上的binlog进行重播，实现主从同步
* 用于数据库的基于时间点的还原



### Reference

1. [乐观锁和 MVCC 的区别？](https://www.zhihu.com/question/27876575)
2. [MySQL binary log](https://dev.mysql.com/doc/refman/8.0/en/binary-log.html)
3. [redo log](https://dev.mysql.com/doc/refman/5.7/en/innodb-redo-log.html)
4. [undo logs](https://dev.mysql.com/doc/refman/5.7/en/innodb-undo-logs.html)