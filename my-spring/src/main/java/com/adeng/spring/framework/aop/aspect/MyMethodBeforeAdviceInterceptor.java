package com.adeng.spring.framework.aop.aspect;

import com.adeng.spring.framework.aop.interceptor.MyMethodInterceptor;
import com.adeng.spring.framework.aop.interceptor.MyMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author hzwengcheng 2019-04-26 15:02
 */
public class MyMethodBeforeAdviceInterceptor extends MyAbstractAspectAdvice implements MyMethodInterceptor {


    public MyMethodBeforeAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(MyMethodInvocation invocation) throws Throwable {
        return null;
    }
}
