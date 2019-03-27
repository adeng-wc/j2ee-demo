package com.adeng.patterns.structural.proxy.custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 参考 {@link InvocationHandler}
 *
 * @author hzwengcheng 2019-03-27 11:53
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
