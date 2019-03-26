package com.adeng.patterns.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK {@link InvocationHandler} 接口实现动态代理
 * <p>
 * 比如JDBC，就是代理模式，不同厂商实现不同，通过定义相同的接口调用
 */
public class JDKProxy<T> implements InvocationHandler {

    //代理对象的引用
    private T target;

    public T getInstance(T target) {
        this.target = target;

        Class clzz = target.getClass();

        /*
            通过JKD的Proxy.newProxyInstance方法创建代理对象。
         */
        return (T) Proxy.newProxyInstance(clzz.getClassLoader(),
                clzz.getInterfaces(), this);
    }

    /**
     * JDK 字节码重组后调用的业务方法。
     *
     * @param proxy  自动生成的代理对象
     * @param method 需要代理的方法
     * @param args   需要代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始代理");

        System.out.println("调用代理对象方法");

        System.out.println("自动生成的代理对象："+proxy.getClass());

        /*
            常见问题是出现递归：
            method.invoke(proxy, args);

            这样调用，会出现死循环

            当外层调用  dog.run()的时候，生成的$Proxy0类会调用$Proxy0父类的InvocationHandler的invoke方法，
            `super.h.invoke(this, m3, (Object[])null)`，也就是当前的这个方法，传入的this是$Proxy0类。

            如果你在当前方法中传入`Object proxy`对象，就会出现循环调用。
         */
        method.invoke(this.target, args);


        System.out.println("结束代理");

        return null;
    }
}
