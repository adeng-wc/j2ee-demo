package com.adeng.customize.mybatis.core.session;

import com.adeng.customize.mybatis.core.config.Configuration;
import com.adeng.customize.mybatis.core.executor.Executor;

import java.lang.reflect.Proxy;

/**
 * Created by w11282 on 2018/4/3.
 */
public class SqlSession {

    private Configuration configuration;

    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 获取对应Mapper的代理类,
     * 因为Mapper接口没有实现类，只能通过代理的方式来处理
     *
     * @param clazz Mapper接口
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(this, configuration));
    }

    public <T> T selectOne(String sql, Class entiry) {
        return executor.query(sql, entiry);
    }
}
