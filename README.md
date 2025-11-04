# Redis学习项目

这是一个基于Redis的多种应用场景的学习项目，包含缓存、会话管理、计数、消息队列、实时分析和分布式锁等六个常见使用场景的实现示例。

## 项目结构

```
.
├── doc/                    # 文档目录，包含各场景的详细说明
├── redis/                  # 各个Redis应用场景的代码实现
│   ├── example00-common    # Redis基础配置和缓存示例
│   ├── example01-session   # 会话管理示例
│   ├── example02-count     # 计数器示例
│   ├── example03-message   # 消息队列示例
│   ├── example04-analise   # 实时分析示例
│   └── example05-lock      # 分布式锁示例
├── docker-compose.yml      # Docker配置文件
└── pom.xml                 # Maven项目配置文件
```

## 技术栈

- Java 8+
- Spring Boot
- Redis
- Maven
- Docker

## Redis简介

Redis（Remote Dictionary Server）是一个开源的、基于内存的高性能键值（Key-Value）数据库，由 Salvatore Sanfilippo（antirez）于 2009 年创建。它不仅支持简单的字符串存储，还提供了丰富的数据结构（如列表、集合、哈希、有序集合等），并具备持久化、高可用、分布式、事务、发布订阅等企业级能力。

更多关于Redis的详细介绍请参考：[Redis 简介](doc/Redis%20简介.md)

## 应用场景

### 1. 缓存（Cache）
使用Redis作为缓存层存储热点数据，提高系统性能。

实现要点：
- RedisTemplate配置
- 数据缓存与读取
- 缓存过期策略

详情请参考：[场景一（缓存）](doc/1.场景一（缓存）.md)

### 2. 会话存储（Session）
使用Redis存储用户会话信息，实现分布式会话管理。

实现要点：
- Spring Session集成
- Redis存储Session
- JSON序列化配置

详情请参考：[场景二（会话）](doc/2.场景二（会话）.md)

### 3. 计数器（Count）
利用Redis原子性操作实现计数功能，如文章浏览量、点赞数等。

实现要点：
- INCR/DECR原子操作
- 排行榜实现
- 数据统计

详情请参考：[场景三（计数）](doc/3.场景三（计数）.md)

### 4. 消息队列（Message Queue）
使用Redis的发布/订阅功能实现简单的消息队列。

实现要点：
- 消息发布与订阅
- 消息监听器配置
- RedisTemplate与ReactiveRedisTemplate

详情请参考：[场景四（消息队列）](doc/4.场景四（消息队列）.md)

### 5. 实时分析（Real-time Analysis）
使用有序集合(ZSet)实现用户在线时长统计和分析。

实现要点：
- ZSet数据结构使用
- 分数累加操作
- 实时排行查询

详情请参考：[场景五（实时分析）](doc/5.场景五（实时分析）.md)

### 6. 分布式锁（Distributed Lock）
使用Redisson实现分布式锁，解决分布式系统中的并发问题。

实现要点：
- Redisson集成
- RLock可重入锁
- 锁的获取与释放

详情请参考：[场景六（分布式锁）](doc/6.场景六（分布式锁）.md)

## Redis相关问题解答

### 单线程问题
很多人会有疑问："Redis既然是单线程的，怎么能承载百万QPS？不会成为性能瓶颈吗？"

实际上Redis的"单线程"是指处理网络I/O和执行命令的核心逻辑是单线程的，但它通过以下方式实现了高性能：

1. 纯内存操作
2. 高效的I/O多路复用
3. 避免线程切换和锁竞争
4. 简单的命令处理逻辑

详情请参考：[单线程问题](doc/单线程问题.md)

## 快速开始

1. 确保已安装Docker
2. 运行以下命令启动Redis服务：
   ```bash
   docker-compose up -d
   ```
3. 进入相应的example目录，运行Spring Boot应用

## 学习建议

建议按照文档顺序逐一学习各个场景的实现方式，理解Redis在不同业务场景下的应用方法。

每个场景都有完整的代码示例和详细的文档说明，可以帮助您更好地掌握Redis的各种使用技巧。