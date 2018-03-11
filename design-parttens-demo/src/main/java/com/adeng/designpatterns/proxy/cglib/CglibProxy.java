package com.adeng.designpatterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CglibProxy {

    public Object getInstance(Class clazz) {
        //增强类
        Enhancer enhancer = new Enhancer();
        //设置代理对象继承的类
        enhancer.setSuperclass(clazz);

        /*   *//*
            设置回调，执行所有有返回类型方法都会被替换成"Hello cglib"
         *//*
        e.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });*/


        /*  *//*
            代理对象的每个方法被调用都会`InvocationHandler`拦截,
            InvocationHandler可以对被调用方法进行解析，但是调用invoke方法会死循环
         *//*
        e.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("InvocationHandler被调用");
                System.out.println("Method:"+method.toString());
                System.out.println(proxy.getClass().toString());

                if (method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {

                    return method.invoke(proxy, args);
                } else {
                    throw new RuntimeException("你想调用什么方法？");
                }
            }
        });*/

        /*
            MethodInterceptor 可以对代理对象方法进行调动。
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method,
                                    Object[] args, MethodProxy proxy) throws Throwable {

                System.out.println("MethodInterceptor.intercept() 被" + method.toString() + "调用");

                System.out.println(obj.getClass().toString());

                return proxy.invokeSuper(obj, args);
            }
        });

        return enhancer.create();
    }


}
