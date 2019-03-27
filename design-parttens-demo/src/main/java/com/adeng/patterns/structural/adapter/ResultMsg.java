package com.adeng.patterns.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMsg {

    private int code;
    private String msg;
    private Object data;
}
