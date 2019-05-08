package com.adeng.spring.framework.aop.aspect;

import com.adeng.spring.framework.aop.interceptor.MyMethodInterceptor;
import com.adeng.spring.framework.aop.interceptor.MyMethodInvocation;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author hzwengcheng 2019-04-26 15:02
 */
@Data
public class MyMethodAfterThrowAdviceInterceptor extends MyAbstractAspectAdvice implements MyMethodInterceptor {

    private String throwName;

    public MyMethodAfterThrowAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(MyMethodInvocation invocation) throws Throwable {
        return null;
    }


}
