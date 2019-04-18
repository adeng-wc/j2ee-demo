package com.adeng.spring.framework.context;

import com.adeng.spring.framework.annotation.MyAutowired;
import com.adeng.spring.framework.annotation.MyController;
import com.adeng.spring.framework.annotation.MyService;
import com.adeng.spring.framework.beans.MyBeanWrapper;
import com.adeng.spring.framework.beans.config.MyBeanDefinition;
import com.adeng.spring.framework.beans.support.MyBeanDefinitionReader;
import com.adeng.spring.framework.beans.support.MyDefaultListableBeanFactory;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzwengcheng 2019-04-17 17:40
 */
@NoArgsConstructor
public class MyApplicationContext extends MyDefaultListableBeanFactory {

    private String[] configLocations;
    private MyBeanDefinitionReader reader;
    /**
     * 单例的IOC容器缓存
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     *
     */
    private Map<String, MyBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    public MyApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    public void refresh() {
        //1. 定位配置文件
        reader = new MyBeanDefinitionReader(configLocations);

        //2. 加载配置文件，扫描相关的类，把他们封装成 BeanDefinition
        List<MyBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //3. 注册，把配置信息放到容器里面（伪IOC容器）
        doRegisterBeanDefinition(beanDefinitions);

        //4. 把不是延迟加载的类，初始化
        doAutowrited();
    }

    /**
     * 暂时只处理非延迟加载
     */
    private void doAutowrited() {
        for (Map.Entry<String, MyBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegisterBeanDefinition(List<MyBeanDefinition> beanDefinitions) {
        for (MyBeanDefinition beanDefinition : beanDefinitions) {
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    /**
     * 先初始化，在注入；避免循环依赖。
     *
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) throws Exception {
        MyBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);

        // 1. 初始化
        MyBeanWrapper beanWrapper = instantiateBean(beanName, beanDefinition);

        // 把 beanWrapper 存入 IOC 缓存
        this.factoryBeanInstanceCache.put(beanName, beanWrapper);

        // 2. 注入
        populateBean(beanName, new MyBeanDefinition(), beanWrapper);

        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    /**
     * 依赖注入
     *
     * @param beanName
     * @param beanDefinition
     * @param beanWrapper
     */
    private void populateBean(String beanName, MyBeanDefinition beanDefinition, MyBeanWrapper beanWrapper) {
        Object instance = beanWrapper.getWrappedInstance();

        Class<?> clazz = beanWrapper.getWrappedClass();
        //判断只有加了注解的类，才执行依赖注入
        if (clazz.isAnnotationPresent(MyController.class) || clazz.isAnnotationPresent(MyService.class)) {
            return;
        }

        //获得所有的fields
        for (Field field : clazz.getDeclaredFields()) {
            if (!field.isAnnotationPresent(MyAutowired.class)) {
                continue;
            }

            MyAutowired autowired = field.getAnnotation(MyAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                autowiredBeanName = field.getType().getName();
            }
            try {
                //TODO  为什么会为null?
                if (this.factoryBeanInstanceCache.get(autowiredBeanName) == null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(instance, this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过读取 MyBeanDefinition 的配置，初始化实例对象
     *
     * @param beanName
     * @param beanDefinition
     */
    private MyBeanWrapper instantiateBean(String beanName, MyBeanDefinition beanDefinition) {
        //1.拿到要实例化的对象的类名
        String className = beanDefinition.getBeanClassName();

        //2.反射实例化，得到一个对象
        Object instance = null;
        try {
            if (this.singletonObjects.containsKey(className)) {
                instance = this.singletonObjects.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                this.singletonObjects.put(className, instance);
                this.singletonObjects.put(beanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.把这个对象封装到 beanWrapper 中

        return new MyBeanWrapper(instance);
    }
}
