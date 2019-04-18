package com.adeng.spring.framework.context.support;

import com.adeng.spring.framework.context.MyApplicationContext;

/**
 *
 * 通过解耦方式获得IOC容器。
 * 后面通过一个监听器去扫描所有的类。
 *
 * @author hzwengcheng 2019-04-17 20:33
 */
public interface MyApplicationContextAware {

    /**
     *
     * @param applicationContext
     */
    void setApplicationContext(MyApplicationContext applicationContext);
}
