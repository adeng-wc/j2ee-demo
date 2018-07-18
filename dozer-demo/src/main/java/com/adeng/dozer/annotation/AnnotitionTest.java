package com.adeng.dozer.annotation;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.junit.Test;

/**
 * @author hzwengcheng 2018-06-28 17:39
 */
public class AnnotitionTest {

    @Test
    public void test() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();

        SourceBean b = new SourceBean();
        b.setId(1L);
        b.setName("test");

        TargetBean a = mapper.map(b, TargetBean.class);

        System.out.println(b.toString());
        System.out.println(a.toString());
//        Assert.assertEquals(a, b);

    }
}
