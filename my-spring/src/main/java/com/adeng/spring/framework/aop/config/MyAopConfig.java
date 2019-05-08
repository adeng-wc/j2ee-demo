package com.adeng.spring.framework.aop.config;

import lombok.Data;

/**
 * @author hzwengcheng 2019-04-26 14:28
 */
@Data
public class MyAopConfig {

    private String pointCut;
    private String aspectBefore;
    private String aspectAfter;
    private String aspectClass;
    private String aspectAfterThrow;
    private String aspectAfterThrowName;
}
