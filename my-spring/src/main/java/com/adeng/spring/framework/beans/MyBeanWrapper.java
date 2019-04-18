package com.adeng.spring.framework.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzwengcheng 2019-04-18 11:59
 */
@Data
@NoArgsConstructor
public class MyBeanWrapper {

    Object instance;

    public MyBeanWrapper(Object instance) {
        this.instance = instance;
    }

    /**
     * Return the bean instance wrapped by this object.
     */
    public Object getWrappedInstance() {
        return instance;
    }

    /**
     * Return the type of the wrapped bean instance.
     */
    public Class<?> getWrappedClass() {
        return instance.getClass();
    }
}
