package com.adeng.mybatis.springmvc.demo.dao.mapper;

import com.adeng.mybatis.springmvc.demo.dao.model.Test;
import com.adeng.mybatis.springmvc.demo.dao.model.TestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    int insertBatch(List<Test> tests);

    List<Test> selectAll();
}