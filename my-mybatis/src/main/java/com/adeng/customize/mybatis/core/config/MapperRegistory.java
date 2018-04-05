package com.adeng.customize.mybatis.core.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by w11282 on 2018/4/3.
 */
public class MapperRegistory {

    /**
        Mapper全路径名称，对应的实体类
     */
    private Map<String, Class> mapperMap= new HashMap<>();

    public void registor(String name, Class obj) {
        mapperMap.put(name, obj);
    }

    /**
     * 通过Mapper全路径名称找对应实体类
     * @param name
     * @return
     */
    public Class get(String name){
        return mapperMap.get(name);
    }
}
