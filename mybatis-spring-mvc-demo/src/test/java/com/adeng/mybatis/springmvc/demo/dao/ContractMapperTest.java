package com.adeng.mybatis.springmvc.demo.dao;

import com.adeng.mybatis.springmvc.demo.BaseTest;
import com.adeng.mybatis.springmvc.demo.dao.mapper.ContractMapper;
import com.adeng.mybatis.springmvc.demo.dao.model.Contract;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * @author
 * @create 2018-03-27 下午10:32
 */
public class ContractMapperTest extends BaseTest{

    private final static Logger log = LoggerFactory.getLogger(ContractMapperTest.class);

    @Autowired
    private ContractMapper mapper;


    @Test
    public void select(){
        Contract contract = mapper.selectByPrimaryKey(1);

        System.out.println(contract.toString());
    }

    /**
     * Key 必须是自增主键，insert的时候才可以使用  useGeneratedKeys="true" keyProperty="id"
     */
    @Test
    @Rollback(false)
    public void insert(){
        Contract contract = new Contract();
        contract.setProjectId(2);
        contract.setMoney(111);
        log.info("{}", mapper.insert(contract));
        log.info("{}", contract.getId());
    }

}
