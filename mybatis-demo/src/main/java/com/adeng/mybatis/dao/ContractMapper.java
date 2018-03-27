package com.adeng.mybatis.dao;

import com.adeng.mybatis.dao.model.Contract;
import com.adeng.mybatis.dao.model.ContractExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractMapper {
    long countByExample(ContractExample example);

    int deleteByExample(ContractExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    List<Contract> selectByExample(ContractExample example);

//    @Select("select * from t_contract where id = #{id}")
    Contract selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}