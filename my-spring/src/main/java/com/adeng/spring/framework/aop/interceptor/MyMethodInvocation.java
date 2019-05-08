package com.adeng.spring.framework.aop.interceptor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author hzwengcheng 2019-04-26 10:50
 */
public class MyMethodInvocation {

    Object proxy;
    Object target;
    Method method;
    Object[] arguments;
    Class<?> targetClass;
    List<Object> interceptorsAndDynamicMethodMatchers;

    public MyMethodInvocation(Object proxy,
                              Object target,
                              Method method,
                              Object[] arguments,
                              Class<?> targetClass,
                              List<Object> interceptorsAndDynamicMethodMatchers) {

        this.proxy = proxy;
        this.target = target;
        this.targetClass = targetClass;
        this.method = method;
        this.arguments = arguments;
        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }


    public Object proceed() throws Throwable {

        return null;
    }

}
