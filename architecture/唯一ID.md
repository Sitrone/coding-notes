# 唯一ID生成算法

* UUID/GUID

```markdown
UUID can be suboptimal for many uses-cases because:

- It isn't the most character efficient way of encoding 128 bits of randomness
- UUID v1/v2 is impractical in many environments, as it requires access to a unique, stable MAC address
- UUID v3/v5 requires a unique seed and produces randomly distributed IDs, which can cause fragmentation in many data structures
- UUID v4 provides no other information than randomness which can cause fragmentation in many data structures
```

* ULID 

  字典序的全局唯一ID

```markdown
Instead, here in is proposed ULID:

- 128-bit compatibility with UUID
- 1.21e+24 unique ULIDs per millisecond
- Lexicographically sortable!
- Canonically encoded as a 26 character string, as opposed to the 36 character UUID
- Uses Crockford's base32 for better efficiency and readability (5 bits per character)
- Case insensitive
- No special characters (URL safe)
- Monotonic sort order (correctly detects and handles the same millisecond)
```

* MySQL自增ID

* redis的自增

* snowflake

* 数据段

  即在MySQL中存储每一次分配的起始id和步长，提起更新MySQL缓存一批步长到发号器服务中，由发号器内存分配，可以采取2段式，避免1段分配完了缓存击穿

* 客户端缓存+数据段

  提供发号器SDK接入，发号器的号段直接缓存到SDK里面，其余逻辑同上，性能会更高一个级别



### 参考

1. [分布式ID生成算法总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/system-design/micro-service/%E5%88%86%E5%B8%83%E5%BC%8Fid%E7%94%9F%E6%88%90%E6%96%B9%E6%A1%88%E6%80%BB%E7%BB%93.md)

