package com.adeng.customize.mybatis.core.handler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by w11282 on 2018/4/3.
 */
public class ResultSetHandler {

    public <T> T handler(ResultSet resultSet, Class entiry) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Object instance = null;
        if (resultSet.next()) {
            //记录resultSet中的下标
            int i = 0;

            //利用反射构造实例对象
            Constructor constructor = entiry.getDeclaredConstructor();
            instance = constructor.newInstance();

            //利用反射赋值属性
            for (Field field : instance.getClass().getDeclaredFields()) {
                String first = field.getName().substring(0, 1);
                String tail = field.getName().substring(1);
                String methodName = "set" + first.toUpperCase() + tail;
                Method setMethod = instance.getClass().getMethod(methodName, field.getType());

                setMethod.invoke(instance, getResult(field, resultSet));
            }
        }

        return (T) instance;
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        //TODO type handles
        Class<?> type = field.getType();
        if(Integer.class == type){
            return rs.getInt(field.getName());
        }
        if(String.class == type){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }
}

