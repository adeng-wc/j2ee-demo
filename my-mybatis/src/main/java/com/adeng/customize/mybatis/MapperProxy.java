package com.adeng.customize.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Mapper的代理类
 *
 * @author
 * @create 2018-04-02 下午10:29
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    //被代理类的接口
    private Class clazz;

    public MapperProxy(SqlSession sqlSession, Class clazz) {
        this.sqlSession = sqlSession;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        String sql = "select * from test where id = #id";

        return sqlSession.selectOne(sql, args);
    }


}
