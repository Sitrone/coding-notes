* 索引 
  * MyISAM的是非聚簇索引，叶子节点只存储指针，主键索引和普通索引一样
  * InnoDB主键使用聚簇索引，普通索引使用非聚簇索引，普通索引存储的是主键
  * InnoDB只能有一个聚簇索引，且建议主键使用一个与业务无关的单调递增字段
* count(*) 
  * MyISAM直接存储总行数，InnoDB需要按行扫描 
* MyISAM支持全文索引，InnoDB 5.6之前的版本不支持 
* MyISAM不支持事务，InnoDB支持事务 
* MyISAM不支持外键，InnoDB支持外键 
* MyISAM只支持表锁，InnoDB支持表锁和行锁

