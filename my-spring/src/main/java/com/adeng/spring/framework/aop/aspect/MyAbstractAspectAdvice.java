package com.adeng.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author hzwengcheng 2019-04-26 15:32
 */
public abstract class MyAbstractAspectAdvice {

    private Method aspectMethod;
    private Object aspectTarget;

    public MyAbstractAspectAdvice(Method aspectMethod, Object aspectTarget) {
        this.aspectMethod = aspectMethod;
        this.aspectTarget = aspectTarget;
    }
}
