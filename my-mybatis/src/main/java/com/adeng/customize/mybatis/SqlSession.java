package com.adeng.customize.mybatis;

import java.lang.reflect.Proxy;

/**
 * 交互的类
 *
 * @author
 * @create 2018-04-02 下午10:17
 */
public class SqlSession {

    private Configuration configuration;

    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class clazz) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this, clazz));
    }


    public <T> T selectOne(String sql, Object[] args) {
        return executor.query(sql, args);
    }
}
