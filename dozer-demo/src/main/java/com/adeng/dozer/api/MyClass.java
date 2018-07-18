package com.adeng.dozer.api;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.classmap.RelationshipType;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.junit.Test;

import java.util.Date;

import static org.dozer.loader.api.FieldsMappingOptions.*;
import static org.dozer.loader.api.TypeMappingOptions.mapId;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;

/**
 * @author hzwengcheng 2018-06-28 17:46
 */
public class MyClass {

    @Test
    public void create() {

        BeanMappingBuilder builder = new BeanMappingBuilder() {

            @Override
            protected void configure() {
                mapping(NotSameAttributeA.class, NotSameAttributeB.class,
                        TypeMappingOptions.oneWay(),
                        mapId("A"),
                        mapNull(true)
                )
                        .exclude("excluded")
                        .fields("name", "value",
                                copyByReference(),
                                collectionStrategy(true, RelationshipType.NON_CUMULATIVE),
                                hintA(String.class),
                                hintB(Integer.class),
                                FieldsMappingOptions.oneWay(),
                                useMapId("A"),
                                customConverterId("id")
                        );
//                        .fields("src", "dest",
//                                customConverter("org.dozer.CustomConverter")
//                        );
            }
        };

        Mapper mapper = DozerBeanMapperBuilder.create()
                .withMappingBuilder(builder)
                .build();

        com.adeng.dozer.attributenotequals.NotSameAttributeB b = com.adeng.dozer.attributenotequals.NotSameAttributeB.builder().id(1).value("test").date(new Date()).build();
        com.adeng.dozer.attributenotequals.NotSameAttributeA a = mapper.map(b, com.adeng.dozer.attributenotequals.NotSameAttributeA.class);

        System.out.println(b.toString());
        System.out.println(a.toString());
    }

}
