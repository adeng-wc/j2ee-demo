package com.adeng.dozer.attributenotequals;

import lombok.*;

import java.util.Date;

/**
 * @author hzwengcheng 2018-06-28 16:56
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotSameAttributeA {
    private long id;
    private String name;
    private Date date;
}
