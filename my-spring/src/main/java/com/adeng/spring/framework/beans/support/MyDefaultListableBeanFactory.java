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
    public Object getBean(String name) throws Exception {
        return this.beanDefinitionMap.get(name);
    }

    @Override
    public Object getBean(Class clazz) throws Exception {
        return this.beanDefinitionMap.get(toLowerFirstCase(clazz.getSimpleName()));
    }

    /**
     * 首字母，大写变小写
     *
     * @param simpleName
     * @return
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        /*
            大小写字母的ASCII码相差32
            大小写字母的 ASCII 小于小写字母的 ASCII
            在Java中，对char做算学运算，实际上就是对 ASCII 码做算学运算
         */
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
