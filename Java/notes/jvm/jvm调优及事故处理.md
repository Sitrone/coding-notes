### jvm事故处理 
1. jstat查看gc情况
```shell
jstat -gcutil <pid> 100
```
2. jmap查看对象占用情况 
```shell
jmap -history:live <pid>
```
3. jmap生成转储文件进行分析，分析工具`Eclipse Memory Analyzer(MAT)`
```shell
jmap -dump:live,format=b,file=heap-dump.bin <pid>
```

### jvm调优
1. 确定调优的系统目标，延迟、吞吐还是内存占用，或者是系统目前已经出现问题需要定位
2. 

### Ref
1. [JVM数据紧急收集脚本](https://github.com/vipshop/vjtools/tree/master/vjdump)
2. [JAVA面试经常会被问题 JVM调优？](https://www.zhihu.com/question/268821097)
3. [如何合理的规划一次jvm性能调优](https://juejin.im/post/59f02f406fb9a0451869f01c)
4. [jvm系列(九):如何优化Java GC](http://www.ityouknow.com/jvm/2017/09/21/How-to-optimize-Java-GC.html)

