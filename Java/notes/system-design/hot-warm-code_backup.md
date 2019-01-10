# 热备份、温备份、冷备份(Hot/Warm/Cold Backup)

* 热备 

热备份（Hot Backup）是指在数据库运行中直接备份，对正在运行的数据库没有任何影响。  

**优点**：恢复时间短，一般几十分钟到数小时，数据完整性与一致性最好，数据丢失可能性最小。

**缺点**：设备投资大，通信费用高，通信环境要求高，平时运行管理较复杂。

使用场景：



* 冷备 

冷备份（Cold Backup）是指在数据库停止的情况下进行备份，这种备份最为简单，一般只需要拷贝相关的数据库物理文件即可  

**优点**：设备投资较少，节省通信费用，通信环境要求不高。

**缺点**：恢复时间较长，一般要数天至1周，数据完整性与一致性较差。

使用场景：



* 温备

温备份（Warm Backup）备份同样是在数据库运行时进行，但是会对当前数据库的操作有所影响，例如加一个全局读锁以保证备份数据的一致性

**优点**：设备投资较少，通信环境要求不高

**缺点**：恢复时间长，一般要十几个小时至数天，数据完整性与一致性较差
