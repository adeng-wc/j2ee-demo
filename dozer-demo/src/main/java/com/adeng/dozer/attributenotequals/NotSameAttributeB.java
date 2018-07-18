package com.adeng.dozer.attributenotequals;

import lombok.*;

import java.util.Date;

/**
 * @author hzwengcheng 2018-06-28 16:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotSameAttributeB {
    private long id;
    private String value;
    private Date date;
}
