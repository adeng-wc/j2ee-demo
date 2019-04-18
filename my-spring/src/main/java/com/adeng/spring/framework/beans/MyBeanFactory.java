package com.adeng.spring.framework.beans;

/**
 * Bean Factory.
 * <p>
 * 暂时默认所有Bean都是单例
 *
 * @author hzwengcheng 2019-04-17 16:59
 */
public interface MyBeanFactory {

    /**
     * 根据 beanName从IOC容器中获得一个实例Bean
     *
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;

    /**
     * 通过类来初始化
     *
     * @param clazz
     * @return
     */
    Object getBean(Class clazz) throws Exception;

}
