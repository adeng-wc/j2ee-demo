package com.adeng.dozer.api;

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
    private Long id;
    private String name;
    private Date date;
}
