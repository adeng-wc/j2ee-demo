package com.adeng.java8.concurrent;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author hzwengcheng 2018-06-18 10:30
 */
@Data
@Builder
public class CombinedEntity {

    private String name;

    private String nickName;

    private Date birthDay;

}
