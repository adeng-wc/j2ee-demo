package com.adeng.mybatis.springmvc.demo.web;

import com.adeng.mybatis.springmvc.demo.dao.mapper.ContractMapper;
import com.adeng.mybatis.springmvc.demo.dao.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * web入口
 *
 * @author
 * @create 2018-03-25 上午10:52
 */
@Controller
public class ContractController {

    private final ContractMapper contractMapper;

    @Autowired
    public ContractController(ContractMapper contractMapper) {
        this.contractMapper = contractMapper;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        Contract contract = contractMapper.selectByPrimaryKey(1);
        return contract.toString();
    }
}
