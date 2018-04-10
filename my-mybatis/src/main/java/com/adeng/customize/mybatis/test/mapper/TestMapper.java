package com.adeng.customize.mybatis.test.mapper;

import com.adeng.customize.mybatis.core.mapper.Entiry;
import com.adeng.customize.mybatis.core.mapper.Select;
import com.adeng.customize.mybatis.test.model.Test;

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

    @Select("select * from test")
    List<Test> selectAll();
}