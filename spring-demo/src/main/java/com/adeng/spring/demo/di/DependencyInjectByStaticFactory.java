package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;

/**
 * 静态工程注入
 *
 * @author
 * @create 2018-03-25 下午1:57
 */
public class DependencyInjectByStaticFactory {

    public static HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }
}
