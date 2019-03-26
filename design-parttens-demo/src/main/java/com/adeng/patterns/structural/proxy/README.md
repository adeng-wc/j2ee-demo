#代理模式

特点：代理模式拥有被代理对象的控制权，可以在调用代理对象前后增加自己的额外操作。
     
代理和委派的主要区别：代理是要对某个对象拥有决定的控制权。而委派，侧重的是任务的分发。

 - 静态代理 - 每当接口有新增的时候，必须重写代理类
 - 动态代理 - 新增接口方法方便，不需要重写代理类
   - JDK - 代理对象必须实现`InvocationHandler`，被代理对象必须实现某接口。
      >       原理：
      >        1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
      >        2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
      >        3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
      >        4、编译新生成的Java代码.class
      >        5、再重新加载到JVM中运行
      >        以上这个过程就叫字节码重组
      
      自动生成的代理对象类：`public final class $Proxy0 extends Proxy implements Dog `
      
      自动生成的代理对象调用方法：`(String)super.h.invoke(this, m2, (Object[])null);`
   - Cglib - 从输出的class文件可以看到，`public final class ChaiQuan$$EnhancerByCGLIB$$b68b430c extends Proxy implements ChaiQuan`,
   可以猜想，Cglib将`ChaiQuan`类变成了接口，然后生成一个实现这个接口的代理对象。
   与JKD的区别是，对代理对象没有必须要实现接口的要求。
   
   