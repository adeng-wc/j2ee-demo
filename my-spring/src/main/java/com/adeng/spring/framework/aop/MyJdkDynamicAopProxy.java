package com.adeng.spring.framework.aop;

import com.adeng.spring.framework.aop.interceptor.MyMethodInvocation;
import com.adeng.spring.framework.aop.support.MyAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author hzwengcheng 2019-04-26 10:37
 */
public class MyJdkDynamicAopProxy implements MyAopProxy, InvocationHandler {

    /**
     * Config used to configure this proxy
     */
    private final MyAdvisedSupport advised;

    public MyJdkDynamicAopProxy(MyAdvisedSupport config) {
        this.advised = config;
    }

    @Override
    public Object getProxy() {
        return getProxy(this.advised.getTargetClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, this.advised.getTargetClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> interceptorsAndDynamicMethodMatchers =
                this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, this.advised.getTargetClass());

        MyMethodInvocation invocation =
                new MyMethodInvocation(proxy, this.advised.getTarget(), method,
                        args, this.advised.getTargetClass(),
                        interceptorsAndDynamicMethodMatchers);

        return invocation.proceed();
    }
}
