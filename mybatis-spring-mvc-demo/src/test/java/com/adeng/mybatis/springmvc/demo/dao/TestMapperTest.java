package com.adeng.mybatis.springmvc.demo.dao;

import com.adeng.mybatis.springmvc.demo.BaseTest;
import com.adeng.mybatis.springmvc.demo.dao.mapper.TestMapper;
import com.adeng.mybatis.springmvc.demo.dao.model.TestExample;
import com.adeng.mybatis.springmvc.demo.enums.TestEnum;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2018-03-28 下午11:19
 */
public class TestMapperTest extends BaseTest {
    private final static Logger log = LoggerFactory.getLogger(TestMapperTest.class);
    @Autowired
    private TestMapper mapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Test
    public void select() {
        System.out.println(mapper.selectByPrimaryKey(1));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void insert() {
        com.adeng.mybatis.springmvc.demo.dao.model.Test test
                = new com.adeng.mybatis.springmvc.demo.dao.model.Test();
        test.setName(TestEnum.A.name());
        test.setNums(12);
        log.info("{}", mapper.insert(test));
        log.info("{}", test.getId());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void insertBatch3() {
        long start = System.currentTimeMillis();
        List<com.adeng.mybatis.springmvc.demo.dao.model.Test> tests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            com.adeng.mybatis.springmvc.demo.dao.model.Test test
                    = new com.adeng.mybatis.springmvc.demo.dao.model.Test();
            test.setName(TestEnum.A.name());
            test.setNums(i);
            tests.add(test);
        }
        mapper.insertBatch(tests);
        log.info("cost {}ms", System.currentTimeMillis() - start);
    }

    @Test
    public void pagination() {
        List<com.adeng.mybatis.springmvc.demo.dao.model.Test> tests =
                sqlSessionTemplate.selectList("selectAll", null, new RowBounds(2, 10));
        log.info(" {}", tests);
    }

    @Test
    public void pagination2() {
        PageHelper.startPage(1, 20);
        PageInfo<Object> page = PageHelper.startPage(1, 10).doSelectPageInfo(new ISelect() {
            public void doSelect() {
                mapper.selectAll();
            }
        });
        log.info(" {}", page);
    }

    @Test
    public void example() {
        TestExample example = new TestExample();
        example.setLimitClause("0,10");
        example.createCriteria().andNameLike("").andIdGreaterThan(10);
        List<com.adeng.mybatis.springmvc.demo.dao.model.Test> tests
                = mapper.selectByExample(example);
    }
}
