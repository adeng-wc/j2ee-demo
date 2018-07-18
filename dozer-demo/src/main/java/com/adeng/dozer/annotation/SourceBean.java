package com.adeng.dozer.annotation;

import lombok.ToString;
import org.dozer.Mapping;

/**
 * @author hzwengcheng 2018-06-28 17:38
 */
@ToString
public class SourceBean {

    private Long id;

    private String name;

    @Mapping("binaryData")
    private String data;

    @Mapping("pk")
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(long i) {
        this.id = i;
    }

    public void setName(String name) {
        this.name = name;
    }
}
