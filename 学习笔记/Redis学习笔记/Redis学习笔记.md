# Redis 学习笔记 2020.12.20记录

## Nosql 概述

### 为什么要用Nosql？

> 1. 单机MySQL的年代！

![](C:\Users\DH\Desktop\GitHubCode\LeetCodeAlgorithm\学习笔记\Redis学习笔记\Redis学习笔记.assets\单机MySQL.png)

90 年代，一个基本的网站访问量一般不会太大，单个数据库完全足够！

那个时候，更多的是使用静态网页 Html。服务器根本没有太大的压力！

这个情况下：**整个网站的瓶颈是什么？**

1. 数据量太大，一个机器放不下！
2. 数据的索引(B+ Tree) 超过300万就一定要创索引。如果索引太多，一个机器内存也放不下。
3. 数据库的访问量(读写混合)，一个服务器承受不了。

   只要你开始出现以上三种情况之一，那就要升级。

> Memcached(缓存) + Mysql + 垂直拆分 (读写分离)

网站80%的情况都是在执行读的操作， 用户每次访问都要查询数据库的话效率会十分低下，所以希望减轻数据压力的话会使用缓存技术来保证效率！

发展过程：优化MySQL数据结构和索引--->文件缓存( IO )---> Memcached (当时热门的技术)

![](C:\Users\DH\Desktop\GitHubCode\LeetCodeAlgorithm\学习笔记\Redis学习笔记\Redis学习笔记.assets\进阶-读写分离.png)

> 3. 分库分表 + 水平拆分 + MySQL 集群

==本质：数据库(读 + 写)==

MySQL数据库：

+ 早些年 MyISAM：使用的表级锁 (比如100万的数据中查张三的密码，这个引擎会把整张表锁住)，其他的进程不能访问表中的数据，导致效低下。在高并发下会出现严重的问题！
+ 转战InnoDB：

![](C:\Users\DH\Desktop\GitHubCode\LeetCodeAlgorithm\学习笔记\Redis学习笔记\Redis学习笔记.assets\分库分表 + 水平拆分 + MySQL 集群.png)