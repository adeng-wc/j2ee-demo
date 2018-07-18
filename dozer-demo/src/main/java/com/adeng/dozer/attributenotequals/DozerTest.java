package com.adeng.dozer.attributenotequals;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.junit.Test;

import java.util.Date;

/**
 * @author hzwengcheng 2018-06-28 16:58
 */
public class DozerTest {


    @Test
    public void test() {
//        Mapper mapper = DozerBeanMapperBuilder.buildDefault();

        Mapper mapper = DozerBeanMapperBuilder.create()
                .withMappingFiles("dozerBeanMapping.xml").build();

        NotSameAttributeB b = NotSameAttributeB.builder().id(1).value("test").date(new Date()).build();
        NotSameAttributeA a = mapper.map(b, NotSameAttributeA.class);

        System.out.println(b.toString());
        System.out.println(a.toString());
//        Assert.assertEquals(a, b);

    }
}
