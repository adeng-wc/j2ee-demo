package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;

/**
 * 实例工厂
 *
 * @author
 * @create 2018-03-25 下午2:01
 */
public class DependencyInjectByInstanceFactory {

    public HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }
}
