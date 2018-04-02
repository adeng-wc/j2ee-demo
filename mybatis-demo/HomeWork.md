实用篇一20180324作业 
1. Mapper在spring管理下其实是单例，为什么可以是一个
单例？ SCOPE -> application

> 答：TestMapper就是一个定义了Test有那些可以操作的接口，没有实现类。
并且Mybatis利用 TestMapper生成的代理类MapperProxy也只是利用该接口的方法再去调用SqlSession。

>所以，我认为TestMapper的主要作用是：
    1、定义Test类的数据库操作方法，避免直接使用sqlsession.selectOne等方法

>唯一变化的也就是SqlSession了。在Mybatis中SqlSession是Method级别的。
而在Mybatis-spring中，利用SqlSessionTemplate封装了SqlSession的代理对象SqlSessionInterceptor。
每次操作都会获取SqlSession。

2. MyBatis在Spring集成下没有mapper的xml文件会不会
报错，为什么？

>答：不一定，没有XML，可以有注解 

3. TypeHandler手写
 
4. 手写Plugin,多个interceptor到底谁先执行？顺序由谁
决定的？

>答：InterceptorChain有个pluginAll方法，循环遍历interceptor的。所以是按添加的顺序。

 
实用篇二20180325作业

1.怎么验证一级缓存的存在？

2.验证N+1问题


源码分析一20180328作业

1. org.apache.ibatis.binding.MapperProxy#invoke 这个类的53行什么时候执行？

> 答：JDK8 接口可以增加默认方法实现，所以该方法是可以调用。


源码分析作业 20180331

1. TestMapper 作者为什么要设计这样的形式来做？
为什么不是一个class而是一个interface?
> 答： TestMapper的作用仅仅是定位操作Test的数据库方法。根本就没有实现类。

2.org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义
 
> 答：org.apache.ibatis.executor.BaseExecutor.DeferredLoad.canLoad 
这里判断是否能加载的时候回使用到org.apache.ibatis.executor.ExecutionPlaceholder.EXECUTION_PLACEHOLDER。
 
3.MyBatis的plugin实现机制
> 答：org.apache.ibatis.session.Configuration.interceptorChain。
org.apache.ibatis.plugin.InterceptorChain.pluginAll中会循环遍历所有注册的Interceptor，
并且调用plugin方法，plugin中会调用Plugin.wrap(target, this)，这是动态代理的方法。
也就是说，plugin会与Executor组合代理对象，并且层层代理。
 
4.lazy loading 是怎么做到的？
>答：org.apache.ibatis.executor.resultset.DefaultResultSetHandler.createResultObject
通过获取ResultMapping中的PropertyResultMappings，并判断是否是懒加载，如果是就不执行

> 并且org.apache.ibatis.executor.resultset.DefaultResultSetHandler.getNestedQueryMappingValue


 