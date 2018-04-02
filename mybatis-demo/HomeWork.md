实用篇一20180324作业 
1. Mapper在spring管理下其实是单例，为什么可以是一个
单例？ SCOPE -> application

TestMapper就是一个定义了Test有那些可以操作的接口，没有实现类。
并且Mybatis利用 TestMapper生成的代理类MapperProxy也只是利用该接口的方法再去调用SqlSession。

所以，我认为TestMapper的主要作用是：
    1、定义Test类的数据库操作方法，避免直接使用sqlsession.selectOne等方法

唯一变化的也就是SqlSession了。在Mybatis中SqlSession是Method级别的。


2. MyBatis在Spring集成下没有mapper的xml文件会不会
报错，为什么？

不一定，没有XML，可以有注解 

3. TypeHandler手写
 
4. 手写Plugin,多个interceptor到底谁先执行？顺序由谁
决定的？

InterceptorChain有个pluginAll方法，循环遍历interceptor的。所以是按添加的顺序。

 
实用篇二20180325作业

1.怎么验证一级缓存的存在？

2.验证N+1问题


源码分析一20180328作业

1. org.apache.ibatis.binding.MapperProxy#invoke 这个类的53行什么时候执行？

JDK8 接口可以增加默认方法实现，所以该方法是可以调用。
