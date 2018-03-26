package com.adeng.mybatis.springmvc.demo.dao.mapper;

import com.adeng.mybatis.springmvc.demo.dao.model.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContractMapper {

    @Select("select * from t_contract where id = #{id}")
    Contract selectByPrimaryKey(@Param("id") Integer id);

}