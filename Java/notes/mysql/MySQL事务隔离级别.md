## 事务

### 事务定义 

指作为单个逻辑工作单元执行的一系列操作，要么完全地执行，要么完全地不执行。



### 属性 

**`A`**`tomic` : 原子性，一个事务（transaction）中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节，如果在中间某个环节出现错误，则rollback

**`C`**`onsistency`: 一致性， 一个事务执行前后不会破坏数据库的完整性

**`I`**`solation`: 数据库允许多个并发事务同时对其数据进行读写和修改的能力，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致

**`D`**`urability`: 事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失

### 隔离级别 

**不同事务的隔离级别，实际上是一致性与并发性的一个权衡与折衷**，事务隔离级别越高，性能越差，反之亦反

|                           | 解决问题                                                     |
| ------------------------- | ------------------------------------------------------------ |
| 读未提交`Read Uncommit`   | 脏读，一个事务读到另一个事务中还没有提交的数据               |
| 读已提交`Read Commited`   | 不可重复读，同一个事务中两次读到的数据不一致                 |
| 可重复读`Repeatable Read` | 幻读，可以看成不可重复读的一个特例，一次事务中由于有新的记录的插入导致多次读取的结果不一致 |
| 串行化Serializable`       |                                                              |



幻读例子：

你正在为医院写一个医生轮班管理程序。医院通常会同时要求几位医生待命，但底线是至少有一位医生在待命。医生可以放弃他们的班次（例如，如果他们自己生病了），只要至少有一个同事在这一班中继续工作。在两个事务中，应用首先检查是否有两个或以上的医生正在值班；如果是的话，它就假定一名医生可以安全地休班。由于数据库使用快照隔离，两次检查都返回 2 ，所以两个事务都进入下一个阶段。Alice更新自己的记录休班了，而Bob也做了一样的事情。两个事务都成功提交了，现在没有医生值班了。违反了至少有一名医生在值班的要求。



#### 事务隔离级别的实现 

* 读未提交 

1. `select`不加锁

* 读已提交 RC

1. 普通`select`是快照读，快照总是读取最新的快照数据
2. `加锁select /update /delete` 会使用记录锁

* 可重复读RR

1. 普通`select`是快照读，快照是读取首次读取的数据，后续不会读取其他已提交事务的写入记录，保证多次读取结果相同
2. `加锁select /update /delete` 根据查询条件情况，会选择记录锁，或者间隙锁/临键锁
   * 在唯一索引上使用了查询条件，使用记录锁
   * 范围查询了条件，使用间隙锁（gap lock）或临建锁（next-key lock）

* 串行化

1. 所有`select`隐式转换成`SELECT ... FOR SHARE`



`InnoDB`默认的隔离级别是RR，使用最多的隔离级别是RC；在RR下面通过临建锁（next-key locking）策略来防止幻读的出现

### Reference 

1. [Transaction Isolation Levels](https://dev.mysql.com/doc/refman/8.0/en/innodb-transaction-isolation-levels.html)
2. [ACID](https://zh.wikipedia.org/wiki/ACID)
3. [Phantom_reads](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Phantom_reads) 
4. [ddia-chapter7](https://vonng.gitbooks.io/ddia-cn/content/ch7.html)
5. [InnoDB Locking](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html)