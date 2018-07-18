package com.adeng.dozer.annotation;

import lombok.ToString;

/**
 * @author hzwengcheng 2018-06-28 17:39
 */
@ToString
public class TargetBean {

    private String pk;

    private String name;

    private String binaryData;

    public void setPk(String pk) {
        this.pk = pk;
    }

    public void setName(String name) {
        this.name = name;
    }
}
