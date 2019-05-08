package com.adeng.spring.framework.aop;

import com.adeng.spring.framework.aop.support.MyAdvisedSupport;

/**
 * @author hzwengcheng 2019-04-26 10:37
 */
public class MyCglibAopProxy implements MyAopProxy {

    public MyCglibAopProxy(MyAdvisedSupport config) {

    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
