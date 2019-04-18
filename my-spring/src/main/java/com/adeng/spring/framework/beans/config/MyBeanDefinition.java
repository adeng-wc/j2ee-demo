package com.adeng.spring.framework.beans.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzwengcheng 2019-04-17 20:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBeanDefinition {
    private String beanClassName;
    private boolean lazyInit = false;
    private boolean isSingleton = true;
    private String factoryBeanName;
}
