package com.adeng.spring.framework.beans.support;

import com.adeng.spring.framework.beans.MyBeanFactory;
import com.adeng.spring.framework.beans.config.MyBeanDefinition;
import com.adeng.spring.framework.context.support.MyAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzwengcheng 2019-04-17 20:23
 */
public class MyDefaultListableBeanFactory extends MyAbstractApplicationContext implements MyBeanFactory {

    /**
     * Map of bean definition objects, keyed by bean name
     */
    protected final Map<String, MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    public Object getBean(String name)  {
        return this.beanDefinitionMap.get(name);
    }
}
