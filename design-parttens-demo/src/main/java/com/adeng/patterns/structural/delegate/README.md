# 委派模式

负责任务的调度和分配任务。跟代理模式很像，可以看做是一种特殊情况下的静态代理的全权代理，但是代理模式注重过程，而委派模式注重结果。
 
 代理模式会增加前后逻辑，委派一般直接调用。 


Spring 常见的例子就是 MVC中的 `DispatcherServlet` 请求分发。
   
   