package com.adeng.spring.framework.aop.interceptor;

/**
 * @author hzwengcheng 2019-04-26 11:12
 */
public interface MyMethodInterceptor {

    Object invoke(MyMethodInvocation invocation) throws Throwable;
}
