package com.adeng.customize.mybatis.core.session;

import com.adeng.customize.mybatis.core.mapper.Select;
import com.adeng.customize.mybatis.core.config.Configuration;
import com.adeng.customize.mybatis.core.config.SqlCommondType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by w11282 on 2018/4/3.
 */
public class MapperProxy implements InvocationHandler{

    private SqlSession sqlSession;
    private Configuration configuration;

    public MapperProxy(SqlSession sqlSession, Configuration configuration) {
        this.sqlSession = sqlSession;
        this.configuration = configuration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        //Mapper对应的实体类
        Class entiry = configuration.getMapperRegistory().get(method.getDeclaringClass().getName());

        //方法全路径名称
        String methodPath = method.getDeclaringClass().getName() + "." + method.getName();

        //sql命令类型
        SqlCommondType sqlCommondType = configuration.getMapperMethodMap().get(methodPath);

        //获取Method上的注解sql
        String sql = null;
        switch (sqlCommondType){
            case ADD:
            case DELETE:
            case SELECT:
                Select select = method.getAnnotation(Select.class);
                sql = select.value();
                break;
            case UPDATE:
            default:
        }

        String str = String.format(sql, args);

        return sqlSession.selectOne(str, entiry);
    }
}
