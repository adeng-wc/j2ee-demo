package com.adeng.spring.framework.aop;

/**
 * @author hzwengcheng 2019-04-26 10:35
 */
public interface MyAopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
