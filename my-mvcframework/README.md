# 简单实现Spring MVC框架


## 实现思路
分三个主要阶段：

- 配置阶段（读取配置参数） 
    - HttpServlet会将web.xml作为入口
    - 根据web.xml中配置的路径找到DispatcherServlet
    - 配置初始化参数，classpath:application.properties
    - /*.json, 指定匹配的URL
- 初始化阶段（初始化类）
    - init()，被web容器调用，如Tomcat
    - 加载application.properties
    - 扫描指定包路径下的类文件
    - IOC容器初始化
    - 依赖注入DI
    - 根初始化HandlerMapping
- 运行阶段(服务调用)
    - service方法
    - 调用一个doDispatch方法
    - 通过反射，动态调用
    - 通过response输出，找不到返回404

