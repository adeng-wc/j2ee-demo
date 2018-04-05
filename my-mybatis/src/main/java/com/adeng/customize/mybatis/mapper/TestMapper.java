package com.adeng.customize.mybatis.mapper;

import com.adeng.customize.mybatis.core.annotation.Entiry;
import com.adeng.customize.mybatis.core.annotation.Select;
import com.adeng.customize.mybatis.model.Test;

import java.util.List;

@Entiry(Test.class)
public interface TestMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);


    @Select("select * from test where id = %d")
    Test selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    int insertBatch(List<Test> tests);

    List<Test> selectAll();
}