## 软件设计原则
- 开闭原则: 对扩展开放，对修改关闭。强调的是用抽象构建框架，用实现扩展细节。

- 依赖倒置原则: 设计代码结构时，高层模块不应该依赖底层模块，二者应该依赖其抽象。抽象不应该依赖细节；细节应该依赖抽象。
    
- 单一职责原则: 一个类，一个方法，只做一件事情，保证单一性。

- 接口隔离原则: 尽量保证接口功能的纯洁性。比如动物接口，细分为吃，飞，游泳3个接口。  

- 迪米特法则: 最少知道原则

- 里是替换原则: 子类可以扩展父类的功能，但不能改变父类原有的功能。

- 合成复用原则: 尽量使用对用组合/聚合，而不是继承关系达到软件复用的目的。


## Spring中用到的设计模式

- 工厂模式，使用者不知道具体实现。
    - BeanFactory
- 装饰器模式，包装之后还是同一个类型。 
    - BeanWrapper
- 代理模式，持有被代理的引用，可以增加额外逻辑。
    - AopProxy
- 单例模式，只有一个对象。
    - ApplicationContext
- 委派模式，将具体工作分发给别人执行。
    - DispatcherServlet
- 适配器模式，通过继承或组合的方式，使原有接口能适配其他功能。
    - HandlerMapping
- 模板方法模式，有固定流程的方法。
    - JDBCTemplate
- 观察者模式，能监听某个对象的事件。
    - ContextLoaderListener

 
 
 
 
 
 
 
 
 
 
 
 
 
 