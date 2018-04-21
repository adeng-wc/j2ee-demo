package com.adeng.lombok.Builder;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

/**
 * @author
 * @create 2018-04-21 23:23
 */
@Builder
public class BuilderExample {

    @Builder.Default
    private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;
}