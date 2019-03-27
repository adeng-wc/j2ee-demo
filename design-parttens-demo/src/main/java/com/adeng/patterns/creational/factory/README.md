
 
 ## 工厂模式
 
 - 简单工厂模式
    - 指由一个工厂对象决定创建出哪一种产品类的实例
 
 - 工厂方法模式
    - 定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法让类的实例化推迟到子类中进行
 
 - 抽象工厂模式
    - 指提供一个创建一系列相关或相互依赖对象的接口，无需指定他们具体的类。
 
 
 ## 单例模式
 - 饿汉式单例
    - 类加载就完成初始化。
 - 懒汉式单例
 
    - 使用 Synchronized
    - double check
        ```java
        
        if (lazy == null) {
            Synchronized(this.class){
                if (lazy == null) {
                    lazy = new lazy();
                }
            }
        }
        
        ```
     - 静态内部类的方式
     
            ```java
             public class A{
                private A(){
                    if (B.A != null) {
                      // 抛异常，防止反射攻击
                    }
                }
                public static final A instance(){
                    return B.A;
                }
                
                private static class B {
                     private static final A = new A();
                }
             }
            
            ```
      - 通过序列化的方式也能破坏单例。重写`readResolve()` 方法，返回单例对象，即可。

 
 - 注册式单例
    - 枚举式：序列化反序列化，枚举是通过类名和Value来判断的。JDK 层面，就保证了枚举单例不能被序列化和反射破坏。
    - 注册式：使用 `static map`,通过 get 方法去取，去的时候使用 `Synchronized`，因为，即使是 `ConcurrentHashMap` 也只能保证自己内部操作原子性。
        
 
 - ThreadLocal单例
    - 伪线程安全，只能保证线程内的安全。
 
 
 ### 破坏单例模式的方式
 
 1. 通过反射来获取。 
    - 避免方法，通过在私有构造函数中增加判断并抛异常。
 2. 通过序列化来获取。
    - 重写 readResolve 方法。
 
 
 

 
 
 
 
 
 